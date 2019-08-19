package com.xdf.femisnsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdf.femisnsb.model.User;
import com.xdf.femisnsb.service.ContinuousServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private ContinuousServiceImpl conuService;
	
	//@GetMapping(value="/hello",produces = "application/json; charset=utf-8")
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String testLombok() {
		User user = new User();

		user.setUserId("1001");
		user.setUserName("chanchaw");
		return user.toString();
	}
	
	@GetMapping("/getNewBillCode")
	@ResponseBody
	public String getNewBillCode() {
		return conuService.getNewBillCode("√Ê¡œ∂©µ•");
	}
	

	
	
}
