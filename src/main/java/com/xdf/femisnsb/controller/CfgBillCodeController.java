package com.xdf.femisnsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.CfgBillCode;
import com.xdf.femisnsb.service.CfgBillCodeServiceImpl;
import com.xdf.utils.StringUtil;

/**   
 * @ClassName:  CfgBillCodeController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����3:32:42   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/cfgBillCode")
public class CfgBillCodeController {

	@Autowired
	private CfgBillCodeServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody CfgBillCode record) {
		return service.insert(record);
	}

	@GetMapping("/deleteByPrimaryKey/{sid}")
	public int deleteByPrimaryKey(@PathVariable("sid") String sid) {
		return service.deleteByPrimaryKey(sid);
	}

	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody CfgBillCode record) {
		return service.updateByPrimaryKey(record);
	}

	@GetMapping("/getByPrimaryKey/{sid}")
	public CfgBillCode getByPrimaryKey(@PathVariable("sid") String sid) {
		return service.getByPrimaryKey(sid);
	}
	
}
