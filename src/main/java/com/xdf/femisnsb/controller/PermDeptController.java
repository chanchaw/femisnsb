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

import com.xdf.femisnsb.model.PermDept;
import com.xdf.femisnsb.service.PermDeptServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/permDept")
public class PermDeptController {

	@Autowired
	private PermDeptServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermDept record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermDept record) {
		return service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/id")
	public PermDept getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<PermDept> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<PermDept> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	public List<PermDept> getAllInvalid(){
		return service.getAllInvalid();
	}
}
