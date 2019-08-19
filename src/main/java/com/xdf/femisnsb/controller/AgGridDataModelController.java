package com.xdf.femisnsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.AgGridDataModel;
import com.xdf.femisnsb.service.AgGridDataModelServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/AgGrid")
public class AgGridDataModelController {

	@Autowired
	private AgGridDataModelServiceImpl service;
	
	@GetMapping("/getAll")
	public List<AgGridDataModel> getAll(){
		return service.getAll();
	}
		
}


