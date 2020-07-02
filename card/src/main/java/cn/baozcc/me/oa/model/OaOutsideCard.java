package cn.baozcc.me.oa.model;

public class OaOutsideCard {
	private String Id;
	private String userphone;
	private String username;
	private String deptid;
	private String deptname;
	private String local_latitude;
	private String local_longitude;
	private String local_addrStr;
	private String local_addrStrAlias;
	private String timecard;
	private String createtime;
	private String createtimeMillisecond;
	private String resType;//4是范围内20是范围外 5是外勤打卡
	private String reason;
	private String time;
	private String already;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLocal_latitude() {
		return local_latitude;
	}
	public void setLocal_latitude(String local_latitude) {
		this.local_latitude = local_latitude;
	}
	public String getLocal_longitude() {
		return local_longitude;
	}
	public void setLocal_longitude(String local_longitude) {
		this.local_longitude = local_longitude;
	}
	public String getLocal_addrStr() {
		return local_addrStr;
	}
	public void setLocal_addrStr(String local_addrStr) {
		this.local_addrStr = local_addrStr;
	}
	public String getLocal_addrStrAlias() {
		return local_addrStrAlias;
	}
	public void setLocal_addrStrAlias(String local_addrStrAlias) {
		this.local_addrStrAlias = local_addrStrAlias;
	}
	public String getTimecard() {
		return timecard;
	}
	public void setTimecard(String timecard) {
		this.timecard = timecard;
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
	public void setCreatetimeMillisecond(String createtimeMillisecond) {
		this.createtimeMillisecond = createtimeMillisecond;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
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
	public String getAlready() {
		return already;
	}
	public void setAlready(String already) {
		this.already = already;
	}
	
	
	
	
	
	

}
