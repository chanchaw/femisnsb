package com.xdf.femisnsb.model;

import java.util.List;

/**   
 * @ClassName:  BillOrder   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��23�� ����12:32:55   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
public class BillOrder {

	@Override
	public String toString() {
		return "BillOrder [main=" + main + ", details=" + details + "]";
	}
	

	public OrderMain getMain() {
		return main;
	}
	public void setMain(OrderMain main) {
		this.main = main;
	}
	
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}
	private OrderMain main;
	private List<OrderDetail> details;
	
	
}
