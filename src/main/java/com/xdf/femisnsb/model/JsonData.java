package com.xdf.femisnsb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonData {
	

	@Override
	public String toString() {
		return "JsonData [success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@JsonIgnore
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private boolean success;
	private String msg;
	private Object data;
	
	public JsonData(boolean success) {
		this.success=success;
	}
	
	public static JsonData success(Object data,String msg) {
		JsonData jd = new JsonData(true);
		jd.msg=msg;
		jd.data=data;
		return jd;
	}
	
	public static JsonData success(Object data) {
		JsonData jd = new JsonData(true);
		jd.msg="";
		jd.data=data;
		return jd;
	}
	
	public static JsonData fail(String msg) {
		JsonData jd = new JsonData(false);
		jd.msg=msg;
		return jd;
	}
}
