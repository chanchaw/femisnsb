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
import com.xdf.femisnsb.model.PermRole;
import com.xdf.femisnsb.service.PermRoleServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/permRole")
public class PermRoleController {

	@Autowired
	private PermRoleServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermRole instance) {
		return service.insert(instance);
	}
	
	@GetMapping("/deleteByPrimaryKey/id")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermRole instance) {
		return service.updateByPrimaryKey(instance);
	}
	
	@GetMapping("/getByPrimaryKey/id")
	public PermRole getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	public List<PermRole> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	public List<PermRole> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	public List<PermRole> getAllInvalid(){
		return service.getAllInvalid();
	}
}
