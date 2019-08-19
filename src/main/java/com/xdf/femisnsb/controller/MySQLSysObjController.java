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

import com.xdf.femisnsb.model.MySQLSchema;
import com.xdf.femisnsb.model.MySQLTable;
import com.xdf.femisnsb.model.MySQLTableCols;
import com.xdf.femisnsb.service.MySQLSysObjServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/mySQLSysObj")
public class MySQLSysObjController {
	
	@Autowired
	private MySQLSysObjServiceImpl service;
	
	@PostMapping("/getCols")
	public List<MySQLTableCols> getCols(@RequestBody MySQLSchema schema) {
		return service.getCols(schema);
	}
	
	@GetMapping("/getTables/{dbname}")
	public List<MySQLTable> getTables(@PathVariable("dbname") String dbname){
		return service.getTables(dbname);
	}
}
