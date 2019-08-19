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

import com.xdf.femisnsb.model.SaleCategory;
import com.xdf.femisnsb.service.SaleCategoryServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/saleCategory")
public class SaleCategoryController {

	@Autowired
	private SaleCategoryServiceImpl service;
	
	@PostMapping("/insert")
	public Integer insert(@RequestBody SaleCategory record) {
		return service.insert(record);
	}
	
	
	@GetMapping("/deleteBPK/{key}")
	public Integer deleteBPK(@PathVariable("key") String key) {
		return service.deleteBPK(key);
	}
	
	
	@PostMapping("/updateBPK")
	public Integer updateBPK(@RequestBody SaleCategory record) {
		return service.updateBPK(record);
	}
	
	
	@GetMapping("/getBPK/{key}")
	public SaleCategory getBPK(@PathVariable("key") String key) {
		return service.getBPK(key);
	}
	
	@GetMapping("getAll")
	public List<SaleCategory> getAll(){
		return service.getAll();
	}
	

	
}
