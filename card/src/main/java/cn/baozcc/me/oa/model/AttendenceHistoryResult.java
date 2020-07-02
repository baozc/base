package cn.baozcc.me.oa.model;

import cn.baozcc.util.json.JsonUtil;

/**
 * @author baozc
 * @date 2019/8/6 9:46 AM
 */
public class AttendenceHistoryResult {

    private String date;
    private OaBean startwork = new OaBean();
    private OaBean gooffwork = new OaBean();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OaBean getStartwork() {
        return startwork;
    }

    public void setStartwork(OaBean startwork) {
        this.startwork = startwork;
    }

    public OaBean getGooffwork() {
        return gooffwork;
    }

    public void setGooffwork(OaBean gooffwork) {
        this.gooffwork = gooffwork;
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
