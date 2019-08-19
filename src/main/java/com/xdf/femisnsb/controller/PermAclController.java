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
import com.xdf.femisnsb.model.PermAcl;
import com.xdf.femisnsb.service.PermAclServicImpl;

@CrossOrigin
@RestController
@RequestMapping("/permAcl")
public class PermAclController {

	@Autowired
	private PermAclServicImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermAcl record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermAcl record) {
		return service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/id")
	public PermAcl getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<PermAcl> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<PermAcl> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	public List<PermAcl> getAllInvalid(){
		return service.getAllInvalid();
	}
}
