package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdf.femisnsb.model.TableStyle;
import com.xdf.femisnsb.service.TableStyleServiceImpl;

@Controller
@CrossOrigin
@RequestMapping("/tableStyle")
public class TableStyleController {

	@Autowired
	private TableStyleServiceImpl service;
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<TableStyle> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	@ResponseBody
	public List<TableStyle> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getSingleTable/{tableName}")
	@ResponseBody
	public List<TableStyle> getSingleTable(@PathVariable("tableName") String tableName){
		return service.getSingleTable(tableName);
	}
	
	
	@GetMapping("/getSingleTableAll/{tableName}")
	@ResponseBody
	public List<TableStyle> getSingleTableAll(@PathVariable("tableName") String tableName){
		return service.getSingleTableAll(tableName);
	}
	
}



