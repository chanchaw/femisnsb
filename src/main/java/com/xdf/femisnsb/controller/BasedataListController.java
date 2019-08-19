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

import com.xdf.femisnsb.model.BasedataList;
import com.xdf.femisnsb.service.BasedataListServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/basedataList")
public class BasedataListController {
	@Autowired
	private BasedataListServiceImpl service;
	
	@GetMapping("/deleteByPrimaryKey/{iid}")
    public int deleteByPrimaryKey(@PathVariable("iid") Integer iid) {
    	return service.deleteByPrimaryKey(iid);
    }

	@PostMapping("/insert")
    public int insert(@RequestBody BasedataList record) {
    	return service.insert(record);
    }

	@PostMapping("/insertSelective")
    public int insertSelective(@RequestBody BasedataList record) {
    	return service.insertSelective(record);
    }

	@GetMapping("/getByPrimaryKey/{iid}")
    public BasedataList getByPrimaryKey(@PathVariable("iid") Integer iid) {
    	return service.getByPrimaryKey(iid); 
    }

	@PostMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(@RequestBody BasedataList record) {
    	return service.updateByPrimaryKeySelective(record);
    }

	@PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(@RequestBody BasedataList record) {
    	return service.updateByPrimaryKey(record);
    }
    
	@GetMapping("/getByPid/{pid}")
    public List<BasedataList> getByPid(@PathVariable("pid") String pid){
    	return service.getByPid(pid);
    }
	
	

}
