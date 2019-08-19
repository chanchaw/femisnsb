package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.dao.OrderMainMapper;
import com.xdf.femisnsb.model.OrderMain;

/**   
 * @ClassName:  OrderMainServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:21:39   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class OrderMainServiceImpl implements OrderMainService {

	@Autowired
	private OrderMainMapper dao;
	
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int insert(OrderMain record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int updateByPrimaryKey(OrderMain record) {
		return dao.updateByPrimaryKey(record);
	}

	public OrderMain getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public OrderMain getPrevious(Integer id) {
		return dao.selectPrevious(id);
	}

	@Override
	public OrderMain getNext(Integer id) {
		return dao.selectNext(id);
	}

	@Override
	public OrderMain getFirst() {
		return dao.selectFirst();
	}

	@Override
	public OrderMain getLast() {
		return dao.selectLast();
	}

	@Override
	public List<OrderMain> getAll() {
		return dao.selectAll();
	}

	@Override
	public List<String> getAllOrderCode() {
		List<OrderMain> list = getAll();
		List<String> data = new ArrayList<>();
		for (OrderMain ele : list) {
			data.add(ele.getCodeid());
		}
		return data;
	}

	@Override
	public int save(OrderMain record) {
		Integer rtn = 0;
		if(record == null) return rtn;
		if(record.getId()<=0)
			rtn = insert(record);
		else {
			updateByPrimaryKey(record);
			rtn = record.getId();
		}
		
		rtn = record.getId();
		return rtn;
	}

	@Override
	public int deleteBPK(Integer id) {
		return dao.deleteBPK(id);
	}

	@Override
	public int deleteBPKImpl(Integer id) {
		return dao.deleteBPKImpl(id);
	}

	@Override
	public int updateBPK(OrderMain record) {
		return dao.updateBPK(record);
	}

	@Override
	public OrderMain selectBPK(Integer id) {
		return dao.selectBPK(id);
	}

	@Override
	public OrderMain getByCodeid(String codeid) {
		return dao.selectByCodeid(codeid);
	}

	@Override
	public boolean isCodeidExists(String codeid) {
		List<OrderMain> list = dao.isCodeidExists(codeid);
		return ( list.size()>0 )?true:false;
	}
	
}
