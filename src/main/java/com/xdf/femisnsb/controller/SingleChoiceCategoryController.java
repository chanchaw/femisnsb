/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  SingleChoiceCategoryController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:17:13   
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

import com.xdf.femisnsb.model.NzTreeNode;
import com.xdf.femisnsb.model.SingleChoiceCategory;
import com.xdf.femisnsb.service.ContactCategoryServiceImpl;
import com.xdf.femisnsb.service.SingleChoiceCategoryServiceImpl;

/**   
 * @ClassName:  SingleChoiceCategoryController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:17:13   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/singleChoiceCategory")
public class SingleChoiceCategoryController {
	private static Logger logger = LoggerFactory.getLogger(ContactCategoryServiceImpl.class);
	
	@Autowired
	private SingleChoiceCategoryServiceImpl service;
	
	
	@PostMapping("/insert")
	public void insert(@RequestBody SingleChoiceCategory record) {
		service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{id}")
	public void deleteByPrimaryKey(Integer id) {
		service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public void updateByPrimaryKey(@RequestBody SingleChoiceCategory record) {
		service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/{id}")
	public SingleChoiceCategory getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<SingleChoiceCategory> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/buildTree")
	public List<NzTreeNode> buildTree(){
		List<NzTreeNode> list = service.buildTree();
		logger.info(list.toString());
		return list;
	}
}
