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
import com.xdf.femisnsb.model.PermAclModule;
import com.xdf.femisnsb.service.PermAclModuleServiceImple;

@CrossOrigin
@RestController
@RequestMapping("/permAclModule")
public class PermAclModuleController {

	@Autowired
	private PermAclModuleServiceImple service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermAclModule instance) {
		return service.insert(instance);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermAclModule instance) {
		return service.updateByPrimaryKey(instance);
	}
	
	@GetMapping("/getByPrimaryKey/id")
	public PermAclModule getByPrimaryKey(@PathVariable("id") Integer id){
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<PermAclModule> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<PermAclModule> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	public List<PermAclModule> getAllInvalid(){
		return service.getAllInvalid();
	}
}
