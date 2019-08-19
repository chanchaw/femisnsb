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

import com.xdf.femisnsb.model.PermRoleAcl;
import com.xdf.femisnsb.service.PermRoleAclServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/permRoleAcl")
public class PermRoleAclController {

	@Autowired
	private PermRoleAclServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermRoleAcl record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermRoleAcl record) {
		return service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/id")
	public PermRoleAcl getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<PermRoleAcl> getAll() {
		return service.getAll();
	}
}
