/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ContactCompanyController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月6日 下午4:05:59   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
 */
package com.xdf.femisnsb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.ContactCompany;
import com.xdf.femisnsb.service.ContactCompanyServiceImpl;

/**
 * @author chanchaw
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/ContactCompany")
public class ContactCompanyController {
	private static Logger logger = LoggerFactory.getLogger(ContactCategoryController.class);
	
	@Autowired
	private ContactCompanyServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody ContactCompany record) {
		logger.info(record.toString());
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{sid}")
	public int deleteByPrimaryKey(@PathVariable("sid") String sid) {
		return service.deleteByPrimaryKey(sid);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody ContactCompany record) {
		logger.info(record.toString());
		System.out.println(record);
		return service.updateByPrimaryKey(record);
	}
	
	@PostMapping("/updateSelective")
	public int updateSelective(@RequestBody ContactCompany record) {
		System.out.println("传入的对象是：");
		System.out.println(record);
		logger.info(record.toString());
		return service.updateSelective(record);
	}
	
	
	@GetMapping("/getByPrimaryKey/{sid}")
	public ContactCompany getByPrimaryKey(@PathVariable("sid") String sid) {
		return service.getByPrimaryKey(sid);
	}
	
	@GetMapping("/getAll")
	public List<ContactCompany> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<ContactCompany> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	public List<ContactCompany> getAllInvalid(){
		return service.getAllInvalid();
	}
	
	@GetMapping("/getChildren/{parentid}")
	public List<ContactCompany> getChildren(@PathVariable("parentid") Integer parentid){
		return service.getChildren(parentid);
	}
}
