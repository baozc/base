package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygScoreOrder implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private String addrjson;

    private String expcom;

    private String expno;

    private String orderid;

    private String remark;

    private Long shareid;

    private Integer status;

    private Long userid;

    private Long userygid;

    private Long buynum;

    private Long ygproductid;

    private String ygproductname;

    private Long ygproductperiod;

    private Long ygproducttotalnum;

    private String ygproductjson;

    private String sendremark;

    private String expcomjson;

    private Date accepttime;

    private Date sendtime;

    private Date sharetime;

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

    public String getAddrjson() {
        return addrjson;
    }

    public void setAddrjson(String addrjson) {
        this.addrjson = addrjson == null ? null : addrjson.trim();
    }

    public String getExpcom() {
        return expcom;
    }

    public void setExpcom(String expcom) {
        this.expcom = expcom == null ? null : expcom.trim();
    }

    public String getExpno() {
        return expno;
    }

    public void setExpno(String expno) {
        this.expno = expno == null ? null : expno.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getShareid() {
        return shareid;
    }

    public void setShareid(Long shareid) {
        this.shareid = shareid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserygid() {
        return userygid;
    }

    public void setUserygid(Long userygid) {
        this.userygid = userygid;
    }

    public Long getBuynum() {
        return buynum;
    }

    public void setBuynum(Long buynum) {
        this.buynum = buynum;
    }

    public Long getYgproductid() {
        return ygproductid;
    }

    public void setYgproductid(Long ygproductid) {
        this.ygproductid = ygproductid;
    }

    public String getYgproductname() {
        return ygproductname;
    }

    public void setYgproductname(String ygproductname) {
        this.ygproductname = ygproductname == null ? null : ygproductname.trim();
    }

    public Long getYgproductperiod() {
        return ygproductperiod;
    }

    public void setYgproductperiod(Long ygproductperiod) {
        this.ygproductperiod = ygproductperiod;
    }

    public Long getYgproducttotalnum() {
        return ygproducttotalnum;
    }

    public void setYgproducttotalnum(Long ygproducttotalnum) {
        this.ygproducttotalnum = ygproducttotalnum;
    }

    public String getYgproductjson() {
        return ygproductjson;
    }

    public void setYgproductjson(String ygproductjson) {
        this.ygproductjson = ygproductjson == null ? null : ygproductjson.trim();
    }

    public String getSendremark() {
        return sendremark;
    }

    public void setSendremark(String sendremark) {
        this.sendremark = sendremark == null ? null : sendremark.trim();
    }

    public String getExpcomjson() {
        return expcomjson;
    }

    public void setExpcomjson(String expcomjson) {
        this.expcomjson = expcomjson == null ? null : expcomjson.trim();
    }

    public Date getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getSharetime() {
        return sharetime;
    }

    public void setSharetime(Date sharetime) {
        this.sharetime = sharetime;
    }
}