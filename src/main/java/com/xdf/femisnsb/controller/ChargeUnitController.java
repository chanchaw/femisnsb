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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2019年1月15日 下午4:54:16   
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
