package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.OrderDetail;

/**   
 * @ClassName:  OrderDetailService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����12:33:14   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface OrderDetailService {
	int insert(OrderDetail record);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(OrderDetail record);
    OrderDetail getByPrimaryKey(Integer id);
    List<OrderDetail> getByMainId(Integer mainId);
    List<OrderDetail> insertBatch(List<OrderDetail> list);
    List<String> getAllOrderCode();
    boolean save(List<OrderDetail> list);
    int saveOne(OrderDetail record);
    int saveOneNull(OrderDetail record);
    int saveList(List<OrderDetail> list);
}
