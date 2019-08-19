package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.ChargeUnitMapper;
import com.xdf.femisnsb.model.ChargeUnit;

/**   
 * @ClassName:  ChargeUnitServiceImple   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��15�� ����4:53:30   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class ChargeUnitServiceImple implements ChargeUnitService {

	@Autowired
	private ChargeUnitMapper dao;
	
	public List<ChargeUnit> getAll() {
		return dao.selectAll();
	}

}
