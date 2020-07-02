package cn.baozcc.me.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import cn.baozcc.me.configuration.constant.Constants;
import cn.baozcc.me.model.PasmUser;
import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.WorkLocationUserRelation;
import cn.baozcc.me.oa.service.OaService;
import cn.baozcc.util.DistanceCalculation;
import cn.baozcc.util.ReturnUtil;
import cn.baozcc.util.result.OaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 考勤打卡
 * @author baozc
 * @date 2019/7/22 5:21 PM
 */
@Controller
@RequestMapping("oa")
public class OaController {

    private Logger logger = LoggerFactory.getLogger(OaController.class);

    @Autowired
    private OaService oaService;

    @PostMapping("oaAttendanceSave/v2")
    @ResponseBody
    public OaResult card(OaBean oa, HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入 OaServletV2,UUID： " + oa.getUuid());

        try {

            // 验证打卡信息情况
            return this.checklocation(oa);

        } catch (Exception e) {

            logger.error(oa.getUuid() + "," + e.toString(), e);
            return ReturnUtil.getCardFailed(e.getMessage(), oa);
        }

    }

    public OaResult checklocation(OaBean oa) {

        PasmUser pasmUser;
        if (Constants.config_app_mobile.equals(Constants.config_app_getInfoType)) {
            pasmUser = oaService.getUserByMyphone(oa.getUserPhone());
        } else {
            pasmUser = oaService.getUserByAccount(oa.getUserPhone());
        }

        if (pasmUser != null) {
            oa.setPasmUser(pasmUser);
        }

        outputLog(oa);

        double distance = distanceCalculation(oa);

        if (distance == 0) {

            logger.error(oa.getUuid() + ",计算打卡位置与工作地点距离失败");
            return ReturnUtil.getCardFailed("计算距离失败：" + oa.getResType() + "," + oa.getUserPhone(), oa);

        } else if (distance > oa.getDistance()) {

            logger.error(oa.getUuid() + ",范围外打卡");

            // 保存范围外打卡信息
            oaService.saveExceptionCard(oa);

            return ReturnUtil.getCardFailed("范围外打卡：" + oa.getResType() + "," + oa.getUserPhone(), oa);
        }

        OaBean attendance = oaService.findAttendanceByUser(oa);

        if (attendance == null) {

            logger.info(oa.getUuid() + ", 不存在打卡记录,保存打卡记录");
            oa.setResType(4);
            oaService.save(oa);
            oa.setAlready("false");

        } else if (oa.getTimecard().equals("2")) {

            logger.info(oa.getUuid() + ", 范围内打卡，保存下班打卡记录");
            oa.setResType(4);
            oa.setId(attendance.getId());
            oaService.update(oa);

        } else if (oa.getTimecard().equals("1")) {

            logger.info(oa.getUuid() + ", 打卡记录已经存在，上班打卡，返回记录，不更新记录");
            oa = attendance;
            oa.setAlready("true");
        }

        return ReturnUtil.getCardSuccess("", oa);
    }

    /**
     * 计算打卡距离<br>
     * 1. 计算默认打卡距离(50m)<br>
     * 2. 如果计算结果大于默认打卡距离(50m)<br>
     *     - 查询是否配置打卡距离<br>
     *     - 验证打卡距离是不小于配置的打卡距离，如果小于停止匹配，否则匹配到最后<br>
     * @param oa
     * @return 计算结果
     * @author baozc
     * @date 2019年07月30日 14:51:48
     */
    private double distanceCalculation(OaBean oa) {

        oa.setDistance(Constants.distance());
        DistanceCalculation DistanceCalculation = new DistanceCalculation();
        @SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder")
        StringBuilder cardRecord = new StringBuilder();

        // 计算签到位置到默认上班地点的距离
        double distance = DistanceCalculation.getShortDistance(oa.getLongitudeParse(), oa.getLatitudeParse(),
                Constants.defaultLon, Constants.defaultLat);
        logger.info(oa.getUuid() + ", 距离默认地点距离：" + distance);

        cardRecord.append("默:").append(Constants.defaultLon).append(",").
                append(Constants.defaultLat).append("距:")
                .append(String.format("%.2f", distance)).append(";");

        // 如果签到位置距离默认上班地点大于50米。再计算距离设置上班地点的距离,对设置固定打开地点的做判断
        if (distance > oa.getDistance()) {

            List<WorkLocationUserRelation> workLocationList = oaService.getWorkLocationByAccount(oa.getAccount());

            //distance原有逻辑，如果数据库里为空，则设置为默认值，数据库可以为空吗？
            for (WorkLocationUserRelation w : workLocationList) {
                distance = DistanceCalculation.getShortDistance(oa.getLongitudeParse(), oa.getLatitudeParse(), w.getLongitude(), w.getLatitude());

                logger.info(oa.getUuid() + ", 设置的上班地点:  " + w.getWorklocation());
                logger.info(oa.getUuid() + ", 设置的上班地点经度:" + w.getLongitude());
                logger.info(oa.getUuid() + ", 设置的上班地点纬度:" + w.getLatitude());
                logger.info(oa.getUuid() + ", 距设置的上班地点距离:" + w.getDistance());

                cardRecord.append("默:").append(w.getLongitude()).append(",")
                        .append(w.getLatitude()).append("距:")
                        .append(String.format("%.2f", distance)).append(";");

                // 如果签到位置距离设置的上班地点小于50米。符合打卡条件退出循环。
                if (distance > 0 && distance < w.getDistance()) {
                    oa.setDistance(w.getDistance());
                    break;
                }
            }
        }

        oa.setExceptionCard(cardRecord.toString());
        return distance;
    }

    private void outputLog(OaBean oa) {
        logger.info(oa.getUuid() + ", username:      " + oa.getUsername());
        logger.info(oa.getUuid() + ", account:       " + oa.getAccount());
        logger.info(oa.getUuid() + ", deptname:      " + oa.getDeptname());
        logger.info(oa.getUuid() + ", deptid:        " + oa.getDeptid());
        logger.info(oa.getUuid() + ", 默认上班地点经度: 	   " + Constants.defaultLon);
        logger.info(oa.getUuid() + ", 默认上班地点纬度:             " + Constants.defaultLat);
        logger.info(oa.getUuid() + ", 系统默认距离:    	   " + Constants.distance());
    }
}
