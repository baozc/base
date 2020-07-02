package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygBigWheelPrize implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Integer acceptprizetype;

    private Long bigwheelid;

    private String coupons;

    private String onlineurl;

    private Long photoid;

    private String photopath;

    private String prizecontent;

    private Integer prizecount;

    private Integer prizelevel;

    private String prizename;

    private Integer prizerate;

    private Long prizescore;

    private Integer prizetype;

    private String takeselfaddress;

    private Long userid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Long getCreatebyid() {
        return createbyid;
    }

    public void setCreatebyid(Long createbyid) {
        this.createbyid = createbyid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getLastmodifyby() {
        return lastmodifyby;
    }

    public void setLastmodifyby(String lastmodifyby) {
        this.lastmodifyby = lastmodifyby == null ? null : lastmodifyby.trim();
    }

    public Long getLastmodifybyid() {
        return lastmodifybyid;
    }

    public void setLastmodifybyid(Long lastmodifybyid) {
        this.lastmodifybyid = lastmodifybyid;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getAcceptprizetype() {
        return acceptprizetype;
    }

    public void setAcceptprizetype(Integer acceptprizetype) {
        this.acceptprizetype = acceptprizetype;
    }

    public Long getBigwheelid() {
        return bigwheelid;
    }

    public void setBigwheelid(Long bigwheelid) {
        this.bigwheelid = bigwheelid;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons == null ? null : coupons.trim();
    }

    public String getOnlineurl() {
        return onlineurl;
    }

    public void setOnlineurl(String onlineurl) {
        this.onlineurl = onlineurl == null ? null : onlineurl.trim();
    }

    public Long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath == null ? null : photopath.trim();
    }

    public String getPrizecontent() {
        return prizecontent;
    }

    public void setPrizecontent(String prizecontent) {
        this.prizecontent = prizecontent == null ? null : prizecontent.trim();
    }

    public Integer getPrizecount() {
        return prizecount;
    }

    public void setPrizecount(Integer prizecount) {
        this.prizecount = prizecount;
    }

    public Integer getPrizelevel() {
        return prizelevel;
    }

    public void setPrizelevel(Integer prizelevel) {
        this.prizelevel = prizelevel;
    }

    public String getPrizename() {
        return prizename;
    }

    public void setPrizename(String prizename) {
        this.prizename = prizename == null ? null : prizename.trim();
    }

    public Integer getPrizerate() {
        return prizerate;
    }

    public void setPrizerate(Integer prizerate) {
        this.prizerate = prizerate;
    }

    public Long getPrizescore() {
        return prizescore;
    }

    public void setPrizescore(Long prizescore) {
        this.prizescore = prizescore;
    }

    public Integer getPrizetype() {
        return prizetype;
    }

    public void setPrizetype(Integer prizetype) {
        this.prizetype = prizetype;
    }

    public String getTakeselfaddress() {
        return takeselfaddress;
    }

    public void setTakeselfaddress(String takeselfaddress) {
        this.takeselfaddress = takeselfaddress == null ? null : takeselfaddress.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}