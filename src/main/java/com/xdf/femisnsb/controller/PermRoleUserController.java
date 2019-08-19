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

import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.service.PermRoleUserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/permRoleUser")
public class PermRoleUserController {

	@Autowired
	private PermRoleUserServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermRoleUser record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermRoleUser record) {
		return service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getAll")
	public List<PermRoleUser> getAll(){
		return service.getAll();
	}
}
