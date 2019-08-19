package com.xdf.femisnsb.model;



/**
 * 系统响应数据的统一格式的类
 * 创建时间：2019年8月5日 23:17:58
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
	 * 查询成功，但是没有数据
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
	 * 查询成功但是没有数据，同时指定了自定义的消息
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
	 * 最常用的方法，查询成功，并且返回数据
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
	 * 查询失败，返回未定义的失败，尽量不要使用
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
	 * 失败时最常用的方法，返回指定的失败编码和消息，不用返回数据
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
	 * 查询失败，返回失败码，但是仍然返回失败的数据，很少用
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
