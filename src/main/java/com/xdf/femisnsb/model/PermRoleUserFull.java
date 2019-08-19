package com.xdf.femisnsb.model;


public class PermRoleUserFull {
   public String getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}
	public String getOperateip() {
		return operateip;
	}
	public void setOperateip(String operateip) {
		this.operateip = operateip;
	}
@Override
	public String toString() {
		return "PermRoleUserFull [id=" + id + ", userid=" + userid + ", username=" + username + ", roleid=" + roleid
				+ ", rolename=" + rolename + ", telephone=" + telephone + ", mail=" + mail + ", password=" + password
				+ ", remark=" + remark + ", deptid=" + deptid + ", status=" + status + ", operator=" + operator
				+ ", operatortime=" + operatetime + ", operatorid=" + operateip + ", hide=" + hide + "]";
	}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Integer getHide() {
		return hide;
	}
	public void setHide(Integer hide) {
		this.hide = hide;
	}
	
	private Integer id;
	private String userid;
   private String username;
   private String roleid;
   private String rolename;
   private String telephone;
   private String mail;
   private String password;
   private String remark;
   private Integer deptid;
   private Integer status;
   private String operator;
   private String operatetime;
   private String operateip;
   private Integer hide;
   
   
}