package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YggPayRecord implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Long amount;

    private String carts;

    private String payno;

    private Integer paystatus;

    private Date paytime;

    private Integer paytype;

    private Date thirdpaytime;

    private String thirdtradeno;

    private String thirdtradestatus;

    private Long userid;

    private String username;

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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCarts() {
        return carts;
    }

    public void setCarts(String carts) {
        this.carts = carts == null ? null : carts.trim();
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno == null ? null : payno.trim();
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Date getThirdpaytime() {
        return thirdpaytime;
    }

    public void setThirdpaytime(Date thirdpaytime) {
        this.thirdpaytime = thirdpaytime;
    }

    public String getThirdtradeno() {
        return thirdtradeno;
    }

    public void setThirdtradeno(String thirdtradeno) {
        this.thirdtradeno = thirdtradeno == null ? null : thirdtradeno.trim();
    }

    public String getThirdtradestatus() {
        return thirdtradestatus;
    }

    public void setThirdtradestatus(String thirdtradestatus) {
        this.thirdtradestatus = thirdtradestatus == null ? null : thirdtradestatus.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}