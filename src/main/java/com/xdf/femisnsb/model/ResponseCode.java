package com.xdf.femisnsb.model;

/**
 * ����ʱ�䣺2019��8��5�� 23:08:01
 * ���ܼ�飺��Ӧ��ǰ�˵�ͳһ�ӿ��ࣺResponseResult �е� ResponseCode
 *        �������ַ��ر���ͷ�����Ϣ
 * @author chanchaw
 *
 */
public enum ResponseCode {
	
	SUCCESS("0000","��ѯ�ɹ�"),
	FAILURE("0001","��ѯʧ��"),
	UNDEFINED_FAILURE("0002","δ�����ʧ��"),
	NODATA("0003","��ѯ�ɹ�����û������"),
	SYSTEM_ERROR("0004","ϵͳ�쳣"),
	
	PARAM_NULL("1000","�������Ϊ��"),
	PARAM_ERROR("1001","�����������"),
	
	BILL_MAIN_NULL("2000","��������Ϊ��"),
	BILL_DETAIL_NULL("2001","������ϸ��Ϊ��"),
	BILL_DETAIL_EMPTY("2002","������ϸ��û������"),	
	BILL_DUPLICATE_CODEID("2003","���ݱ���ظ�"),
	
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
