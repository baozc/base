package cn.baozcc.me.oa.model;

import javax.validation.constraints.NotNull;

import cn.baozcc.me.annotation.Sig;
import cn.baozcc.me.model.PasmUser;
import cn.baozcc.me.oa.model.Base.BaseBean;
import cn.baozcc.util.TimeUtils;
import cn.baozcc.util.json.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

/**
 * @author baozc
 * @date 2019/7/22 5:24 PM
 */
public class OaBean extends BaseBean {

    private String id;

    @JsonIgnore
    @Override
    public String getUuid() {
        return super.getUuid();
    }

    @JsonProperty("userphone")
    @Override
    public String getUserPhone() {
        return super.getUserPhone();
    }

    @JsonIgnore
    @NotNull
    @Sig
    @Override
    public String getUmobile() {
        return super.getUmobile();
    }

    //经度
    @JsonProperty("local_longitude")
    @NotNull
    @Sig
    private String longitude;

    @JsonIgnore
    public double getLongitudeParse() {
        return Double.valueOf(longitude);
    }

    //纬度
    @JsonProperty("local_latitude")
    @NotNull
    @Sig
    private String latitude;

    @JsonIgnore
    public double getLatitudeParse(){
        return Double.valueOf(latitude);
    }

    // 地址名
    @JsonProperty("local_addrStr")
    @NotNull
    @Sig
    private String addrStr;

    @JsonProperty("local_addrStrAlias")
    // 地址别名
    @NotNull
    @Sig
    private String addrStrAlias;
    // 定位方式
    @NotNull
    // @NotEmpty
    @Sig
    private String locType;
    // 打卡类型：1上班，2下班
    @NotNull
    @Sig
    private String timecard;
    @NotNull
    @Sig
    private String username;

    @JsonIgnore
    private String account;

    private String deptname;

    @NotNull
    @Sig
    private String deptpath;
    @NotNull
    @Sig
    private String deptid;

    private int resType;

    private String createtime;
    private String createtimeMillisecond;
    private String reason;

    @JsonIgnore
    private String time;

    @JsonIgnore
    private String imei;

    private String already;

    @JsonIgnore
    private double distance;

    @JsonIgnore
    private String exceptionCard;

    public void setPasmUser(PasmUser pasmUser){
        username = pasmUser.getUsername();
        account = pasmUser.getAccount();
        deptname = pasmUser.getDeptname();
        deptid = pasmUser.getDept_id();
    }

    @JsonProperty("time")
    public String getCurrentDate(){
        if (StringUtils.isEmpty(createtimeMillisecond)) {
            return "";
        }
        return TimeUtils.getCurrentDate(Long.parseLong(createtimeMillisecond));
    }

    public String getExceptionCard() {
        return exceptionCard;
    }

    public void setExceptionCard(String exceptionCard) {
        this.exceptionCard = exceptionCard;
    }

    public String getDeptpath() {
        return deptpath;
    }

    public void setDeptpath(String deptpath) {
        this.deptpath = deptpath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getAlready() {
        return already;
    }

    public void setAlready(String already) {
        this.already = already;
    }

    public String getResType() {
        return String.valueOf(resType);
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    @Override
    @JsonIgnore
    @NotNull
    @Sig
    public String getUid() {
        return uid;
    }

    @Override
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddrStr() {
        return addrStr;
    }

    public void setAddrStr(String addrStr) {
        this.addrStr = addrStr;
    }

    public String getAddrStrAlias() {
        return addrStrAlias;
    }

    public void setAddrStrAlias(String addrStrAlias) {
        this.addrStrAlias = addrStrAlias;
    }

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public String getTimecard() {
        return timecard;
    }

    public void setTimecard(String timecard) {
        this.timecard = timecard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetimeMillisecond() {
        return createtimeMillisecond;
    }

    public void setCreatetimeMillisecond(String createtimeMillsecond) {
        this.createtimeMillisecond = createtimeMillsecond;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {

        return JsonUtil.format(this);
    }
}
