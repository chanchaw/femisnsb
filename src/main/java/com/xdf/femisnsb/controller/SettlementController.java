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

import com.xdf.femisnsb.model.Settlement;
import com.xdf.femisnsb.service.SettlementServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/settlement")
public class SettlementController {
	@Autowired
	private SettlementServiceImpl service;
	
	@PostMapping("/insert")
	public Integer insert(@RequestBody Settlement record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{key}")
	public Integer deleteByPrimaryKey(@PathVariable("key") String key) {
		return service.deleteByPrimaryKey(key);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public Integer updateByPrimaryKey(@RequestBody Settlement record) {
		return service.updateByPrimaryKey(record);
	}
	
	
	@PostMapping("/updateBPKS")
	public Integer updateBPKS(@RequestBody Settlement record) {
		return service.updateBPKS(record);
	}
	
	
	@GetMapping("/getByPrimaryKey/{key}")
	public Settlement getByPrimaryKey(@PathVariable("key") String key) {
		return service.getByPrimaryKey(key);
	}
	
	@GetMapping("/getAll")
	public List<Settlement> getAll(){
		return service.getAll();
	}
}
