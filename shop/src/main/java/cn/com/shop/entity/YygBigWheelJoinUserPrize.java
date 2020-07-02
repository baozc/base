package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class YygBigWheelJoinUserPrize implements Serializable {
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

    private String name;

    private Long prizeid;

    private String prizename;

    private String tel;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPrizeid() {
        return prizeid;
    }

    public void setPrizeid(Long prizeid) {
        this.prizeid = prizeid;
    }

    public String getPrizename() {
        return prizename;
    }

    public void setPrizename(String prizename) {
        this.prizename = prizename == null ? null : prizename.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}