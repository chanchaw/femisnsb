package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xdf.femisnsb.model.FinishedProduct;
import com.xdf.femisnsb.service.FinishedProductServiceImpl;


@Controller
@CrossOrigin
@RequestMapping("/finishedProduct")
public class FinishedProductController {

	@Autowired
	private FinishedProductServiceImpl service;
	
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<FinishedProduct> getAll(){
		return service.getAll();
	}
	
	
	@PostMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody FinishedProduct instance) {
		return service.insert(instance);
	}
	
	@GetMapping("/deleteByPrimaryKey/{sId}")
	@ResponseBody
	public int deleteByPrimaryKey(@PathVariable("sId") String sId) {
		return service.deleteByPrimaryKey(sId);
	}
	
	@PostMapping("/updateByPrimaryKey")
	@ResponseBody
	public int updateByPrimaryKey(@RequestBody FinishedProduct instance) {
		return service.updateByPrimaryKey(instance);
	}
	
	@GetMapping("/getByPrimaryKey/{sId}")
	@ResponseBody
	public FinishedProduct getByPrimaryKey(String sId) {
		return service.getByPrimaryKey(sId);
	}
	

	
	@GetMapping("/getAllValid")
	@ResponseBody
	public List<FinishedProduct> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	@ResponseBody
	public List<FinishedProduct> getAllInvalid(){
		return service.getAllInvalid();
	}
	
	@GetMapping("/isExist/{sId}")
	@ResponseBody
	public boolean isExist(@PathVariable("sId") String sId) {
		return false;
	}
	

	@GetMapping("/getAllChildren/{parentId}")
	@ResponseBody
	public List<FinishedProduct> getAllChildren(@PathVariable("parentId") Integer parentId){
		return service.getAllChildren(parentId);
	}
}
