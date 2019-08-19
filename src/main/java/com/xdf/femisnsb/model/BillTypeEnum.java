package com.xdf.femisnsb.model;

public enum BillTypeEnum {
	
	FABRIC_ORDER("fabricOrder","���϶���"),
	TEXTILES_ORDER("textilesOrder","�ҷĶ���"),
	;
	
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	BillTypeEnum(String code,String name){
		this.code = code;
		this.name = name;
	}
}
