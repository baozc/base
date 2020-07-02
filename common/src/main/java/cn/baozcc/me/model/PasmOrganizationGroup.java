package cn.baozcc.me.model;

/**
 * 部门树
 * @author liux
 *
 */
public class PasmOrganizationGroup{
	
	private String deptId;//子部门
	private String dnid;//父部门
	private Integer level;//父部门是子部门的几级部门
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDnid() {
		return dnid;
	}
	public void setDnid(String dnid) {
		this.dnid = dnid;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
