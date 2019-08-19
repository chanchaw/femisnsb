package com.xdf.femisnsb.controller;

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

import com.xdf.femisnsb.model.BillOrder;
import com.xdf.femisnsb.model.ResponseResult;
import com.xdf.femisnsb.service.BillOrderServiceImpl;
import com.xdf.femisnsb.service.ContinuousServiceImpl;
import com.xdf.femisnsb.service.OrderMainServiceImpl;

/**   
 * @ClassName:  BillOrderController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��23�� ����12:31:39   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/billOrder")
public class BillOrderController {
	private static Logger logger = LoggerFactory.getLogger(ContinuousServiceImpl.class);
	
	@Autowired
	private BillOrderServiceImpl service;
	
	@Autowired
	private OrderMainServiceImpl mService;
	
	@PostMapping("/save")
	public ResponseResult save(@RequestBody BillOrder billOrder) {
		logger.info("���������յ��ĵ��ݶ����ǣ�" + billOrder.toString());
		ResponseResult ret = service.save(billOrder);
		logger.info("����󷵻صĵ��ݶ����ǣ�" + ret.getData().toString());
		return ret;
	}
	
	@GetMapping("/getByPrimaryKey/{mainId}")
	public BillOrder getByPrimaryKey(@PathVariable("mainId") Integer mainId) {
		return service.getByPrimaryKey(mainId);
	}
	
	@GetMapping("/delete/{mainId}")
	public boolean delete(@PathVariable("mainId") Integer mainId) {
		service.delete(mainId);
		
		return true;
	}
	
	@GetMapping("/moveFirst")
	public ResponseResult moveFirst() {
		return service.moveFirst();
	}
	
	@GetMapping("/movePrevious/{billId}")
	public ResponseResult movePrevious(@PathVariable("billId") Integer billId) {
		return service.movePrevious(billId);
	}
	
	@GetMapping("/moveNext/{billId}")
	public ResponseResult moveNext(@PathVariable("billId") Integer billId) {
		return service.moveNext(billId);
	}
	
	@GetMapping("/moveLast")
	public ResponseResult moveLast() {
		return service.moveLast();
	}
	
	@GetMapping("/isCodeidExists/{codeid}")
	public boolean isCodeidExists(@PathVariable("codeid") String codeid) {
		return mService.isCodeidExists(codeid);
	}
}
