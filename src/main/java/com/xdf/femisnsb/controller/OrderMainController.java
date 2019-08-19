package com.xdf.femisnsb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.femisnsb.model.OrderMain;
import com.xdf.femisnsb.service.OrderMainServiceImpl;

/**   
 * @ClassName:  OrderMainController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:22:57   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/orderMain")
public class OrderMainController {
	private static Logger logger = LoggerFactory.getLogger(ContinuousController.class);
	
	@Autowired
	private OrderMainServiceImpl service;

	
	@PostMapping("/insert")
	public int insert(@RequestBody OrderMain record) {
		service.insert(record);
		return record.getId();
	}

	@GetMapping("/deleteByPrimaryKey/{id}")
	public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}

	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody OrderMain record) {
		return service.updateByPrimaryKey(record);
	}

	@GetMapping("/getByPrimaryKey/{id}")
	public OrderMain getByPrimaryKey(@PathVariable("id") Integer id) {
		return service.getByPrimaryKey(id);
	}
	
	@GetMapping("/getPrevious/{id}")
	public OrderMain getPrevious(@PathVariable("id") Integer id) {
		return service.getPrevious(id);
	}
	
	@GetMapping("/getNext/{id}")
	public OrderMain getNext(@PathVariable("id") Integer id) {
		return service.getNext(id);
	}
	
	@GetMapping("/getFirst")
	public OrderMain getFirst() {
		return service.getFirst();
	}
	
	@GetMapping("/getLast")
	public OrderMain getLast() {
		return service.getLast();
	}
	
	
	@GetMapping("/getAll")
	public List<OrderMain> getAll(){
		return service.getAll();
	}
	
	
	@GetMapping("/getAllOrderCode")
	public List<String> getAllOrderCode(){
		return service.getAllOrderCode();
	}
	
	@PostMapping("/save")
	public int save(@RequestBody OrderMain record) {
		logger.info("接收到的参数对象是：");
		logger.info(record.toString());
		return service.save(record);
	}
	
}
