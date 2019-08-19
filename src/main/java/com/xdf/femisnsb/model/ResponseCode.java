package com.xdf.femisnsb.model;

/**
 * 创建时间：2019年8月5日 23:08:01
 * 功能简介：响应给前端的统一接口类：ResponseResult 中的 ResponseCode
 *        用来体现返回编码和返回消息
 * @author chanchaw
 *
 */
public enum ResponseCode {
	
	SUCCESS("0000","查询成功"),
	FAILURE("0001","查询失败"),
	UNDEFINED_FAILURE("0002","未定义的失败"),
	NODATA("0003","查询成功但是没有数据"),
	SYSTEM_ERROR("0004","系统异常"),
	
	PARAM_NULL("1000","传入参数为空"),
	PARAM_ERROR("1001","传入参数错误"),
	
	BILL_MAIN_NULL("2000","单据主表为空"),
	BILL_DETAIL_NULL("2001","单据明细表为空"),
	BILL_DETAIL_EMPTY("2002","单据明细表没有数据"),	
	BILL_DUPLICATE_CODEID("2003","单据编号重复"),
	
	;
	
	
	private String code;
	private String msg;
	
	public String getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	ResponseCode(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
}
