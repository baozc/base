package cn.baozcc.me.oa.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import cn.baozcc.me.oa.model.AttendenceHistoryResult;
import cn.baozcc.me.oa.model.OaBean;
import cn.baozcc.me.oa.model.request.AttendanceHistoryRequest;
import cn.baozcc.me.oa.service.OaService;
import cn.baozcc.util.ReturnUtil;
import cn.baozcc.util.TimeUtils;
import cn.baozcc.util.result.OaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取考勤记录
 * @author baozc
 * @date 2019/8/5 3:58 PM
 */
@Controller
@RequestMapping("oa/OaTimecardTodayServlet")
public class AttendanceHistoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OaService oaService;

    @PostMapping("v1")
    @ResponseBody
    public OaResult v1(AttendanceHistoryRequest today, @RequestHeader("user-agent") String userAgent) {

        try {

            today.setStartTime(TimeUtils.getCurrentDateMilli(today.getStartTime()));

            long end = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(today.getEndTime()), ZoneId.systemDefault())
                    .plusDays(1)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli();

            today.setEndTime(TimeUtils.getCurrentDateMilli(end));

            List<OaBean> list = oaService.findAtendanceHistory(today);

            List<AttendenceHistoryResult> temp = new ArrayList<>();

            AtomicReference<String> currentDate = new AtomicReference<String>();
            list.forEach(l1 -> {

                // 上、下班记录合为一条，只循环一次
                if (StringUtils.isEmpty(currentDate.get()) || !currentDate.get().equals(l1.getCurrentDate())) {

                    currentDate.set(l1.getCurrentDate());
                    AttendenceHistoryResult result = new AttendenceHistoryResult();
                    result.setDate(currentDate.get());

                    list.forEach(l2 -> {
                        if (currentDate.get().equals(l2.getCurrentDate())) {

                            if (l2.getTimecard().equals("1")) {
                                result.setStartwork(l2);
                            } else if (l2.getTimecard().equals("2")) {
                                result.setGooffwork(l2);
                            }
                        }
                    });

                    temp.add(result);
                }
            });

            return ReturnUtil.getCardSuccess("", temp);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getCardFailed(e.getMessage(), today);
        }

    }
}
