package cn.baozcc.me.model;

public class PasmOrganization {
    private String dept_id;//部门id

    private String deptname;//部门名称

    private String super_id;//父级部门id

    private String group_dnid;//部门完整id 例如：.id1.id2.id3  使用.分割

    private String super_name;//父级部门名称，废弃（目前没有值）

    private String deppath;//部门路径 使用/分割 例如：神州良品/物流部  注意  (deppath+deptname与group_dnid对应)

    private String state;//状态（1新增，2修改，3删除）

    private String createtime;//创建时间

    private String updatetime;//修改时间

    private String deletetime;//删除时间(废弃)

    private String rspcode;//同步结果编码  01

    private String rspdesc;//同步结果信息  新增未同步

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id == null ? null : dept_id.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getSuper_id() {
        return super_id;
    }

    public void setSuper_id(String super_id) {
        this.super_id = super_id == null ? null : super_id.trim();
    }

    public String getGroup_dnid() {
        return group_dnid;
    }

    public void setGroup_dnid(String group_dnid) {
        this.group_dnid = group_dnid == null ? null : group_dnid.trim();
    }

    public String getSuper_name() {
        return super_name;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name == null ? null : super_name.trim();
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath == null ? null : deppath.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime == null ? null : deletetime.trim();
    }

    public String getRspcode() {
        return rspcode;
    }

    public void setRspcode(String rspcode) {
        this.rspcode = rspcode == null ? null : rspcode.trim();
    }

    public String getRspdesc() {
        return rspdesc;
    }

    public void setRspdesc(String rspdesc) {
        this.rspdesc = rspdesc == null ? null : rspdesc.trim();
    }

	public String toString() {
		return "PasmOrganization [dept_id=" + dept_id + ", deptname="
				+ deptname + ", super_id=" + super_id + ", group_dnid="
				+ group_dnid + ", super_name=" + super_name + ", deppath="
				+ deppath + ", state=" + state + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", deletetime=" + deletetime
				+ ", rspcode=" + rspcode + ", rspdesc=" + rspdesc + "]";
	}
    
    
}