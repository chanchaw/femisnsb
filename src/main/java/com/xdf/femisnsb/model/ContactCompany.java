package com.xdf.femisnsb.model;

public class ContactCompany {
	private String sid;

    private String name;

    private String code;

    private String alias;

    private String customer;

    private Integer parentid;

    private String bank;

    private String account;

    private String linkman;

    private String phone;

    public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOprimary() {
		return oprimary;
	}

	public void setOprimary(String oprimary) {
		this.oprimary = oprimary;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}

	private String address;

    private Integer status;
    
    private String oprimary;
    
    private String categories;

    private String categoryNames;

	@Override
	public String toString() {
		return "ContactCompany [sid=" + sid + ", name=" + name + ", code=" + code + ", alias=" + alias + ", customer="
				+ customer + ", parentid=" + parentid + ", bank=" + bank + ", account=" + account + ", linkman="
				+ linkman + ", phone=" + phone + ", address=" + address + ", status=" + status + ", oprimary="
				+ oprimary + ", categories=" + categories + ", categoryNames=" + categoryNames + "]";
	}

	
    
  
}