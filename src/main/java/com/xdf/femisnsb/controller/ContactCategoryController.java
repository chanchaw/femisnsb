/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ContactCategoryController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��6�� ����3:06:16   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
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

import com.xdf.femisnsb.model.ContactCategory;
import com.xdf.femisnsb.model.NzTreeNode;
import com.xdf.femisnsb.model.SingleString;
import com.xdf.femisnsb.service.ContactCategoryServiceImpl;


/**
 * @author chanchaw
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/ContactCategory")
public class ContactCategoryController {
	private static Logger logger = LoggerFactory.getLogger(ContactCategoryController.class);

	@Autowired
	private ContactCategoryServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody ContactCategory record) {
		System.out.println("��������������ǣ�" + record.toString());
		logger.info("��������������ǣ�" + record.toString());
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{id}")
	public int deleteByPrimaryKey(@PathVariable("id") String sid) {
		return service.deleteByPrimary(sid);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody ContactCategory record) {
		System.out.println(record);
		return service.updateByPrimary(record);
	}
	
	@GetMapping("/getByPrimaryKey/{id}")
	public ContactCategory getByPrimaryKey(@PathVariable("id") String sid) {
		return service.getByPrimary(sid);
	}
	
	@GetMapping("/getAll")
	public List<ContactCategory> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<ContactCategory> getAllValid(){
		return service.getAllValid();
	}
	
	

	@GetMapping("/buildTree")
	public List<NzTreeNode> buildTree(){
		List<NzTreeNode> list = service.buildTree();
		logger.info("�������л�ȡ�������νṹ�������ǣ�");
		logger.info(list.toString());
		return list;
	}
	
	@GetMapping("/getByTitle/{title}")
	public ContactCategory getByTitle(@PathVariable("title") String title) {
		return service.getByTitle(title);
	}
	
	@GetMapping("/getByName/{name}")
	public ContactCategory getByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}
	
	
	@GetMapping("/getCategoryNames/{categories}")
	public SingleString getCategoryNames(@PathVariable("categories") String categories) {
		String rtnString = service.getCategoryNames(categories);
		SingleString ss = new SingleString(rtnString); 
		return ss;
	}
}
