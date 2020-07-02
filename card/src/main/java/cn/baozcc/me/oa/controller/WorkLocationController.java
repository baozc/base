package cn.baozcc.me.oa.controller;

import java.util.List;

import cn.baozcc.me.configuration.constant.Constants;
import cn.baozcc.me.oa.model.WorkLocationUserRelation;
import cn.baozcc.me.oa.model.request.WorklocationRequest;
import cn.baozcc.me.oa.service.OaService;
import cn.baozcc.util.Des3Util;
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
 * 获取工作位置
 * @author baozc
 * @date 2019/8/5 3:58 PM
 */
@Controller
@RequestMapping("oa/OaworklocationUserRelation")
public class WorkLocationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OaService oaService;

    @PostMapping("v2")
    @ResponseBody
    public OaResult v1(WorklocationRequest worklocation) {

        try {

            String uid = Des3Util.decode(worklocation.getUid());
            logger.info(worklocation.getUuid() + ", 解密完成uid:     " + uid);
            String account = uid.substring(0, uid.lastIndexOf("_"));

            List<WorkLocationUserRelation> list = oaService.getWorkLocationByAccount(account);
            // if (list == null) {
            //     list = new ArrayList<>();
            // }

            list.add(getDefault());

            return ReturnUtil.getCardSuccess("", list);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getCardFailed(e.getMessage(), worklocation);
        }

    }

    private WorkLocationUserRelation getDefault(){
        WorkLocationUserRelation location = new WorkLocationUserRelation();
        location.setLongitude(Constants.defaultLon);
        location.setLatitude(Constants.defaultLat);
        location.setDistance(Constants.distance());
        location.setWorklocation(Constants.worklocation);
        location.setWorklocationAlias(Constants.worklocationAlias);

        return location;
    }
}
