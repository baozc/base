package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygBigWheelJoinUser implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private String address;

    private Long bigwheelid;

    private String email;

    private Boolean isuserinfocommited;

    private String name;

    private String qq;

    private String tel;

    private String weixin;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getBigwheelid() {
        return bigwheelid;
    }

    public void setBigwheelid(Long bigwheelid) {
        this.bigwheelid = bigwheelid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsuserinfocommited() {
        return isuserinfocommited;
    }

    public void setIsuserinfocommited(Boolean isuserinfocommited) {
        this.isuserinfocommited = isuserinfocommited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }
}