package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.ChargeUnit;
import com.xdf.femisnsb.service.ChargeUnitServiceImple;

/**   
 * @ClassName:  ChargeUnitController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��15�� ����4:54:16   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
@RestController
@CrossOrigin
@RequestMapping("/chargeUnit")
public class ChargeUnitController {
	@Autowired
	private ChargeUnitServiceImple service;
	
	@GetMapping("/getAll")
	public List<ChargeUnit> getAll(){
		return service.getAll();
	}
}
