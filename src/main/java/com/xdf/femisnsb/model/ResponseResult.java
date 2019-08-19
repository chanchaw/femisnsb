package com.xdf.femisnsb.model;



/**
 * ϵͳ��Ӧ���ݵ�ͳһ��ʽ����
 * ����ʱ�䣺2019��8��5�� 23:17:58
 * @author chanchaw
 *
 */
public class ResponseResult {
	private boolean success;
	private String code;
	private String msg;
	private Object data;
	
	public ResponseResult() {
		
	}
	
	public ResponseResult( String code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * ��ѯ�ɹ�������û������
	 * @return
	 */
	public static ResponseResult success() {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(true);
		ret.setCode(ResponseCode.NODATA.getCode());
		ret.setMsg(ResponseCode.NODATA.getMsg());
		ret.setData(null);
		return ret;
	}
	
	
	
	/**
	 * ��ѯ�ɹ�����û�����ݣ�ͬʱָ�����Զ������Ϣ
	 * @param msg
	 * @return
	 */
	public static ResponseResult success( String msg ) {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(true);
		ret.setCode(ResponseCode.NODATA.getCode());
		ret.setMsg( msg );
		ret.setData(null);
		return ret;
	}
	
	/**
	 * ��õķ�������ѯ�ɹ������ҷ�������
	 * @param data
	 * @return
	 */
	public static ResponseResult success( Object data  ) {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(true);
		ret.setCode(ResponseCode.SUCCESS.getCode());
		ret.setMsg(ResponseCode.SUCCESS.getMsg());
		ret.setData(data);
		return ret;
	}
	
	/**
	 * ��ѯʧ�ܣ�����δ�����ʧ�ܣ�������Ҫʹ��
	 * @return
	 */
	public static ResponseResult failure() {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(false);
		ret.setCode(ResponseCode.UNDEFINED_FAILURE.getCode());
		ret.setMsg(ResponseCode.UNDEFINED_FAILURE.getMsg());
		ret.setData(null);
		return ret;
	}
	
	/**
	 * ʧ��ʱ��õķ���������ָ����ʧ�ܱ������Ϣ�����÷�������
	 * @param rc
	 * @return
	 */
	public static ResponseResult failure( ResponseCode rc ) {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(false);
		ret.setCode(rc.getCode());
		ret.setMsg(rc.getMsg());
		ret.setData(null);
		return ret;
	}
	
	/**
	 * ��ѯʧ�ܣ�����ʧ���룬������Ȼ����ʧ�ܵ����ݣ�������
	 * @param rc
	 * @param data
	 * @return
	 */
	public static ResponseResult failure( ResponseCode rc,Object data ) {
		ResponseResult ret = new ResponseResult();
		ret.setSuccess(false);
		ret.setCode(rc.getCode());
		ret.setMsg(rc.getMsg());
		ret.setData(data);
		return ret;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
