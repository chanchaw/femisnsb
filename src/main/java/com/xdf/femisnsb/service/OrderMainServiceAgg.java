package com.xdf.femisnsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.model.OrderMain;

@Service
public class OrderMainServiceAgg {

	@Autowired
	private OrderMainServiceImpl service;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int save(OrderMain record) {
		Integer rtn = 0;
		if(record == null) return rtn;
		if(record.getId()<=0)
			rtn = service.insert(record);
		else {
			service.updateByPrimaryKey(record);
			rtn = record.getId();
		}
		
		rtn = record.getId();
		return rtn;
	}
}
