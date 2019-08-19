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

import com.xdf.femisnsb.model.Packmanner;
import com.xdf.femisnsb.service.PackmannerServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/packmanner")
public class PackmannerController {

	@Autowired
	private PackmannerServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody Packmanner record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteBPK/{key}")
	public int deleteBPK(@PathVariable("key") String key) {
		return service.deleteBPK(key);
	}
	
	
	@PostMapping("/updateBPK")
	public int updateBPK(@RequestBody Packmanner record) {
		return service.updateBPK(record);
	}
	
	
	@GetMapping("/getBPK/{key}")
	public Packmanner getBPK(@PathVariable("key") String key) {
		return service.getBPK(key);
	}
	
	@GetMapping("/getAll")
	public List<Packmanner> getAll(){
		return service.getAll();
	}
	
}
