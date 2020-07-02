package cn.baozcc.me.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.OutSideOaBean;
import cn.baozcc.me.oa.service.OaService;
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
 * 外勤打卡
 * @author baozc
 * @date 2019/7/22 5:21 PM
 */
@Controller
@RequestMapping("oa/OaOutSideCard")
public class OutSideCardController {

    private Logger logger = LoggerFactory.getLogger(OutSideCardController.class);

    @Autowired
    private OaService oaService;

    @PostMapping("v1")
    @ResponseBody
    public OaResult card(OutSideOaBean oa, HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入 OaServletV2,UUID： " + oa.getUuid());

        try {

            OaBean attendance = oaService.findAttendanceByUser(oa);

            if (attendance != null) {
                oa.setResType(5);
                oa.setId(attendance.getId());
                oaService.update(oa);

                return ReturnUtil.getCardSuccess("success", oa);
            } else {
                oa.setResType(5);
                oaService.save(oa);

                return ReturnUtil.getCardSuccess("success", oa);
            }

        } catch (Exception e) {

            logger.error(oa.getUuid() + "," + e.toString(), e);
            return ReturnUtil.getCardFailed(e.getMessage(), oa);
        }

    }

}
