package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.Department;
import com.xdf.femisnsb.model.NzTreeNode;
import com.xdf.femisnsb.service.DepartmentServiceImpl;

/**   
 * @ClassName:  DepartmentController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午6:50:28   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody Department record) {
		service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{id}")
	public void deleteByPrimaryKey(Integer id) {
		service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public void updateByPrimaryKey(@RequestBody Department record) {
		service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/{id}")
	public Department getByPrimaryKey(Integer id) {
		return service.getByPrimary(id);
	}
	
	@GetMapping("/getAll")
	public List<Department> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/buildTree")
	public List<NzTreeNode> buildTree(){
		return service.buildTree();
	}
}
