package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.BillOrder;
import com.xdf.femisnsb.model.OrderDetail;
import com.xdf.femisnsb.model.ResponseResult;

/**   
 * @ClassName:  BillOrderService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��23�� ����12:20:12   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface BillOrderService {
	ResponseResult save(BillOrder record);
	boolean delete(Integer mainId);
	BillOrder getByPrimaryKey(Integer mainId);
	
	
	ResponseResult moveFirst();
	ResponseResult movePrevious(Integer billId);
	ResponseResult moveNext(Integer billId);
	ResponseResult moveLast();
	boolean isCodeidExist(String codeid);
	
	int saveBatch(List<OrderDetail> list);
}
