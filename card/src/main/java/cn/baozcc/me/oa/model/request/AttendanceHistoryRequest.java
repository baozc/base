package cn.baozcc.me.oa.model.request;

import javax.validation.constraints.NotNull;

import cn.baozcc.me.annotation.Sig;
import cn.baozcc.me.oa.model.Base.BaseBean;

/**
 * @author baozc
 * @date 2019/8/5 4:04 PM
 */
public class AttendanceHistoryRequest extends BaseBean {

    @NotNull
    @Sig
    private Long startTime;

    @NotNull
    @Sig
    private Long endTime;

    @Override
    @NotNull
    @Sig
    public String getUmobile() {
        return umobile;
    }

    @Override
    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }

    @NotNull
    @Sig
    @Override
    public String getUid() {
        return super.getUid();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    @NotNull
    public String getOs() {
        return os;
    }

    @Override
    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TodayAttendance{");
        sb.append("uid='").append(uid).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", os='").append(os).append('\'');
        sb.append(", sig='").append(sig).append('\'');
        sb.append(", uuid='").append(uuid).append('\'');
        sb.append(", uid='").append(uid).append('\'');
        sb.append(", umobile='").append(umobile).append('\'');
        sb.append(", userPhone='").append(userPhone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
