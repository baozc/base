package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygUserYg implements Serializable {
    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Long buydatelong;

    private Long buynum;

    private Long buyuserid;

    private String buyuserlogopath;

    private String buyusernickname;

    private String clientip;

    private String ipaddr;

    private Long paytradeid;

    private Integer period;

    private Long productid;

    private String productname;

    private Long singleprice;

    private Integer status;

    private Long totalnum;

    private Boolean win;

    private Long winno;

    private Long ygproductid;

    private String isSendSms;

    private String buynos;

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

    public Long getBuydatelong() {
        return buydatelong;
    }

    public void setBuydatelong(Long buydatelong) {
        this.buydatelong = buydatelong;
    }

    public Long getBuynum() {
        return buynum;
    }

    public void setBuynum(Long buynum) {
        this.buynum = buynum;
    }

    public Long getBuyuserid() {
        return buyuserid;
    }

    public void setBuyuserid(Long buyuserid) {
        this.buyuserid = buyuserid;
    }

    public String getBuyuserlogopath() {
        return buyuserlogopath;
    }

    public void setBuyuserlogopath(String buyuserlogopath) {
        this.buyuserlogopath = buyuserlogopath == null ? null : buyuserlogopath.trim();
    }

    public String getBuyusernickname() {
        return buyusernickname;
    }

    public void setBuyusernickname(String buyusernickname) {
        this.buyusernickname = buyusernickname == null ? null : buyusernickname.trim();
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip == null ? null : clientip.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public Long getPaytradeid() {
        return paytradeid;
    }

    public void setPaytradeid(Long paytradeid) {
        this.paytradeid = paytradeid;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Long getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(Long singleprice) {
        this.singleprice = singleprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Long totalnum) {
        this.totalnum = totalnum;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Long getWinno() {
        return winno;
    }

    public void setWinno(Long winno) {
        this.winno = winno;
    }

    public Long getYgproductid() {
        return ygproductid;
    }

    public void setYgproductid(Long ygproductid) {
        this.ygproductid = ygproductid;
    }

    public String getIsSendSms() {
        return isSendSms;
    }

    public void setIsSendSms(String isSendSms) {
        this.isSendSms = isSendSms == null ? null : isSendSms.trim();
    }

    public String getBuynos() {
        return buynos;
    }

    public void setBuynos(String buynos) {
        this.buynos = buynos == null ? null : buynos.trim();
    }
}