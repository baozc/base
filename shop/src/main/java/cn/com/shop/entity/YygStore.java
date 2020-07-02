package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygStore implements Serializable {
    private Long id;

    private String storename;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private Long version;

    private Boolean audit;

    private String mobile;

    private String photos;

    private Boolean recommend;

    private String weixin;

    private Long userid;

    private String userlogopath;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long productid;

    private Long accountbalance;

    private String salescore;

    private Long scoreCanTixian;

    private Long scoreDoTixian;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos == null ? null : photos.trim();
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserlogopath() {
        return userlogopath;
    }

    public void setUserlogopath(String userlogopath) {
        this.userlogopath = userlogopath == null ? null : userlogopath.trim();
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

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(Long accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getSalescore() {
        return salescore;
    }

    public void setSalescore(String salescore) {
        this.salescore = salescore == null ? null : salescore.trim();
    }

    public Long getScoreCanTixian() {
        return scoreCanTixian;
    }

    public void setScoreCanTixian(Long scoreCanTixian) {
        this.scoreCanTixian = scoreCanTixian;
    }

    public Long getScoreDoTixian() {
        return scoreDoTixian;
    }

    public void setScoreDoTixian(Long scoreDoTixian) {
        this.scoreDoTixian = scoreDoTixian;
    }
}