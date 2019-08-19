package com.xdf.femisnsb.model;

public class BillType {

	private String billType;
	private String codeid;
	
	public BillType(String billType,String codeid) {
		this.billType = billType;
		this.codeid = codeid;
	}
	
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getCodeid() {
		return codeid;
	}
	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}
	@Override
	public String toString() {
		return "BillType [billType=" + billType + ", codeid=" + codeid + "]";
	}
	
	
}
