package cn.baozcc.me.model;

public class PasmUser {
    private String account;//用户账号

    private String password;//用户密码

    private String dept_id;//用户部门id

    private String deptname;

    private String deppath;//用户部门全路径

    private String username;//用户名(中文)

    private String pinyin;//用户名(拼音)

    private String myphone;//手机

    private String telephone;//电话

    private String vnumber;//存的还是手机号

    private String email;//邮箱

    private String address;//地址

    private String personorder;//排序编号

    private String employee_num;//员工编号

    private String sex;//性别

    private String note;//备注

    private String state;//状态 1：新增   2：更新   3：删除

    private String createtime;

    private String updatetime;

    private String deletetime;

    private String rspcode;

    private String rspdesc;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id == null ? null : dept_id.trim();
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath == null ? null : deppath.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getMyphone() {
        return myphone;
    }

    public void setMyphone(String myphone) {
        this.myphone = myphone == null ? null : myphone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getVnumber() {
        return vnumber;
    }

    public void setVnumber(String vnumber) {
        this.vnumber = vnumber == null ? null : vnumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPersonorder() {
        return personorder;
    }

    public void setPersonorder(String personorder) {
        this.personorder = personorder == null ? null : personorder.trim();
    }

    public String getEmployee_num() {
        return employee_num;
    }

    public void setEmployee_num(String employee_num) {
        this.employee_num = employee_num == null ? null : employee_num.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
	public String toString() {
		return "PasmUser [account=" + account + ", password=" + password
				+ ", dept_id=" + dept_id + ", deppath=" + deppath
				+ ", username=" + username + ", pinyin=" + pinyin
				+ ", myphone=" + myphone + ", telephone=" + telephone
				+ ", vnumber=" + vnumber + ", email=" + email + ", address="
				+ address + ", personorder=" + personorder + ", employee_num="
				+ employee_num + ", sex=" + sex + ", note=" + note + ", state="
				+ state + ", createtime=" + createtime + ", updatetime="
				+ updatetime + ", deletetime=" + deletetime + ", rspcode="
				+ rspcode + ", rspdesc=" + rspdesc + "]";
	}
    
}