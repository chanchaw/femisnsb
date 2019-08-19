package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.dao.OrderDetailMapper;
import com.xdf.femisnsb.model.OrderDetail;

/**   
 * @ClassName:  OrderDetailServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:39:44   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailMapper dao;
	
	
	public int insert(OrderDetail record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(OrderDetail record) {
		return dao.updateByPrimaryKey(record);
	}

	public OrderDetail getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<OrderDetail> getByMainId(Integer mainId) {
		return dao.selectByMainId(mainId);
	}

	/**
	 * 批量插入的同时从DB端获取自增字段的值
	 * 所以还要再次返回该集合list
	 */
	public List<OrderDetail> insertBatch(List<OrderDetail> list) {
		dao.insertBatch(list);
		return list;
	}

	public List<String> getAllOrderCode() {
		List<OrderDetail> list = dao.selectAllOrderCode();
		List<String> data = new ArrayList<>();
		for (OrderDetail ele:list) {
			data.add(ele.getOrdercode());
		}
		return data;
	}

	public boolean save(List<OrderDetail> list) {
		if(list==null) return false;
		if(list.size()<=0) return false;
		
		for (OrderDetail orderDetail : list) {
			if(orderDetail.getMainid()>0) {
				this.updateByPrimaryKey(orderDetail);
			}else {
				this.insert(orderDetail);
			}
		}
		
		return true;
	}

	@Override
	public int saveOne(OrderDetail record) {
		return dao.saveOne(record);
	}

	@Override
	public int saveOneNull(OrderDetail record) {
		return dao.saveOneNull(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int saveList(List<OrderDetail> list) {
		return dao.saveList(list);
	}

}
