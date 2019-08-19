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

import com.xdf.femisnsb.model.OrderDetail;
import com.xdf.femisnsb.service.OrderDetailServiceImpl;

/**   
 * @ClassName:  OrderDetailController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:41:04   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailServiceImpl service;
	
	@PostMapping("/insert")
	public int insert(@RequestBody OrderDetail record) {
		System.out.println(record);
		return service.insert(record);
	}

	@GetMapping("/deleteByPrimaryKey/{id}")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		System.out.println("要删除的行的主键是：" + id.toString());
		return service.deleteByPrimaryKey(id);
	}

	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody OrderDetail record) {
		System.out.println(record);
		return service.updateByPrimaryKey(record);
	}

	@GetMapping("/getByPrimaryKey/{id}")
	public OrderDetail getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}

	@GetMapping("/getByMainId/{mainId}")
	public List<OrderDetail> getByMainId(@PathVariable("mainId") Integer mainId) {
		return service.getByMainId(mainId);
	}
	
	@PostMapping("/insertBatch")
	public List<OrderDetail> insertBatch(@RequestBody List<OrderDetail> list) {
		return service.insertBatch(list);
	}
	
	@GetMapping("/getAllOrderCode")
	public List<String> getAllOrderCode(){
		return service.getAllOrderCode();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody List<OrderDetail> list) {
		service.save(list);
	}
	
	@PostMapping("/saveOne")
	public int saveOne(@RequestBody OrderDetail record) {
		return service.saveOne(record);
	}
	
	
	@PostMapping("/saveOneNull")
	public int saveOneNull(@RequestBody OrderDetail record) {
		return service.saveOneNull(record);
	}
	
	
	@PostMapping("/saveList")
	public int saveList(@RequestBody List<OrderDetail> list) {
		System.out.println(list);
		return service.saveList(list);
	}
}
