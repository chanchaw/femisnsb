package com.xdf.femisnsb.model;

/**   
 * @ClassName:  SingleString   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2019年1月27日 下午7:49:00   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
public class SingleString {
	@Override
	public String toString() {
		return "SingleString [data=" + data + "]";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private String data;
	
	public SingleString(String data) {
		this.data=data;
	}
}
