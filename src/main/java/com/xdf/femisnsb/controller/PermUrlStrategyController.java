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
import com.xdf.femisnsb.model.PermUrlStrategy;
import com.xdf.femisnsb.service.PermUrlStrategyServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/PermUrlStrategy")
public class PermUrlStrategyController {

	@Autowired
	private PermUrlStrategyServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody PermUrlStrategy record) {
		return service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{url}")
	public int deleteByPrimaryKey(@PathVariable("url") String url) {
		return service.deleteByPrimaryKey(url);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody PermUrlStrategy record) {
		return service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/{url}")
	public PermUrlStrategy getByPrimaryKey(@PathVariable("url") String url) {
		return service.getByPrimaryKey(url);
	}
	
	@GetMapping("/getAll")
	public List<PermUrlStrategy> getAll(){
		return service.getAll();
	}
}
