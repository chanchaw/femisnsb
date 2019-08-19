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
import com.xdf.femisnsb.model.FinishedProductCategory;
import com.xdf.femisnsb.model.NzTreeNode;
import com.xdf.femisnsb.service.FinishedProductCategoryServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/finishedProductCategory")
public class FinishedProductCategoryController {

	@Autowired
	private FinishedProductCategoryServiceImpl service;
	
	@PostMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody FinishedProductCategory instance) {
		return service.insert(instance);
	}
	
	@GetMapping("/deleteByPrimaryKey/{id}")
	@ResponseBody
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}
	
	@PostMapping("/updateByPrimaryKey")
	@ResponseBody
	public Integer updateByPrimaryKey(@RequestBody FinishedProductCategory instance) {
		System.out.println("为修改收到的对象是：" + instance.toString());
		return service.updateByPrimaryKey(instance);
	}
	
	@GetMapping("/getByPrimaryKey/{id}")
	@ResponseBody
	public FinishedProductCategory getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<FinishedProductCategory> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getAllValid")
	@ResponseBody
	public List<FinishedProductCategory> getAllValid(){
		return service.getAllValid();
	}
	
	@GetMapping("/getAllInvalid")
	@ResponseBody
	public List<FinishedProductCategory> getAllInvalid(){
		return service.getAllInvalid();
	}
	
	
	@GetMapping("/getTreeAllValid")
	@ResponseBody
	public List<NzTreeNode> getTreeAllValid(){
		return service.buildTree();
	}
	
	@GetMapping("/isExistByPrimaryKey/{id}")
	@ResponseBody
	public boolean isExistByPrimaryKey(@PathVariable("id") Integer id) {
		return service.isExist(id);
	}
	
	@GetMapping("/isExistByName/{name}")
	@ResponseBody
	public boolean isExistByName(@PathVariable("name") String name) {
		return service.isExist(name);
	}
	
}
