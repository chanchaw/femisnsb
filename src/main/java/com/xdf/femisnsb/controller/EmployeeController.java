package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xdf.femisnsb.model.Employee;
import com.xdf.femisnsb.service.EmployeeServiceImpl;

/**   
 * @ClassName:  EmployeeController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午7:46:21   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody Employee record) {
		service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{sid}")
	public void deleteByPrimaryKey(@PathVariable("sid") String sid) {
		service.deleteByPrimaryKey(sid);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public void updateByPrimaryKey(@RequestBody Employee record) {
		service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/{sid}")
	public Employee getByPrimaryKey(@PathVariable("sid") String sid) {
		return service.getByPrimaryKey(sid);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getChildren/{pid}")
	public List<Employee> getChildren(@PathVariable("pid") Integer pid){
		return service.getChildren(pid);
	}
	
	@GetMapping("/getName/{username}")
	public String getName(@PathVariable("username") String username) {
		return "chanchaw";
	}
}
