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

import com.xdf.femisnsb.model.Package;
import com.xdf.femisnsb.service.PackageServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageServiceImpl service;
	
	@PostMapping("/insert")
	public Integer insert(@RequestBody Package record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteBPK/{key}")
	public Integer deleteBPK(@PathVariable("key") String key) {
		return service.deleteBPK(key);
	}
	
	@PostMapping("/updateBPK")
	public Integer updateBPK(@RequestBody Package record) {
		return service.updateBPK(record);
	}
	
	@GetMapping("/getBPK/{key}")
	public Package getBPK(@PathVariable("key") String key) {
		return service.getBPK(key);
	}
	
	@GetMapping("/getAll")
	public List<Package> getAll(){
		return service.getAll();
	}
		
}
