package com.xdf.femisnsb.model;

/**   
 * @ClassName:  SingleString   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��27�� ����7:49:00   
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
