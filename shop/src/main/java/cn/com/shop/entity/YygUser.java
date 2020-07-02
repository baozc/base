package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygUser implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Long storeid;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Long accountbalance;

    private String address;

    private Long areaid;

    private String cardno;

    private Long cityid;

    private String email;

    private String headphotopath;

    private String mobile;

    private String nickname;

    private String password;

    private String qq;

    private Long seqno;

    private String truename;

    private String username;

    private Integer usertype;

    private Boolean inneruser;

    private Date expirdate;

    private Boolean recommend;

    private Long viplevel;

    private String weixin;

    private String weixincodepath;

    private String weixinlogopath;

    private String birthday;

    private Integer sex;

    private Long provinceid;

    private Long yaoqinguserid;

    private String weixinopenid;

    private String kakaUserid;

    private String idsAkk;

    private Double touzhuTotal;

    private Double winTotal;

    private String isSendMsg;

    private String remark;

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

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
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

    public Long getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(Long accountbalance) {
        this.accountbalance = accountbalance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadphotopath() {
        return headphotopath;
    }

    public void setHeadphotopath(String headphotopath) {
        this.headphotopath = headphotopath == null ? null : headphotopath.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Boolean getInneruser() {
        return inneruser;
    }

    public void setInneruser(Boolean inneruser) {
        this.inneruser = inneruser;
    }

    public Date getExpirdate() {
        return expirdate;
    }

    public void setExpirdate(Date expirdate) {
        this.expirdate = expirdate;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Long getViplevel() {
        return viplevel;
    }

    public void setViplevel(Long viplevel) {
        this.viplevel = viplevel;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getWeixincodepath() {
        return weixincodepath;
    }

    public void setWeixincodepath(String weixincodepath) {
        this.weixincodepath = weixincodepath == null ? null : weixincodepath.trim();
    }

    public String getWeixinlogopath() {
        return weixinlogopath;
    }

    public void setWeixinlogopath(String weixinlogopath) {
        this.weixinlogopath = weixinlogopath == null ? null : weixinlogopath.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }

    public Long getYaoqinguserid() {
        return yaoqinguserid;
    }

    public void setYaoqinguserid(Long yaoqinguserid) {
        this.yaoqinguserid = yaoqinguserid;
    }

    public String getWeixinopenid() {
        return weixinopenid;
    }

    public void setWeixinopenid(String weixinopenid) {
        this.weixinopenid = weixinopenid == null ? null : weixinopenid.trim();
    }

    public String getKakaUserid() {
        return kakaUserid;
    }

    public void setKakaUserid(String kakaUserid) {
        this.kakaUserid = kakaUserid == null ? null : kakaUserid.trim();
    }

    public String getIdsAkk() {
        return idsAkk;
    }

    public void setIdsAkk(String idsAkk) {
        this.idsAkk = idsAkk == null ? null : idsAkk.trim();
    }

    public Double getTouzhuTotal() {
        return touzhuTotal;
    }

    public void setTouzhuTotal(Double touzhuTotal) {
        this.touzhuTotal = touzhuTotal;
    }

    public Double getWinTotal() {
        return winTotal;
    }

    public void setWinTotal(Double winTotal) {
        this.winTotal = winTotal;
    }

    public String getIsSendMsg() {
        return isSendMsg;
    }

    public void setIsSendMsg(String isSendMsg) {
        this.isSendMsg = isSendMsg == null ? null : isSendMsg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}