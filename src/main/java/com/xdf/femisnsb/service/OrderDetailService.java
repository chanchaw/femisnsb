package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.OrderDetail;

/**   
 * @ClassName:  OrderDetailService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:33:14   
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
