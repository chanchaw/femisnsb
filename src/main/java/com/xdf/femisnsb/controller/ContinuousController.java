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

import com.xdf.femisnsb.model.Continuous;
import com.xdf.femisnsb.model.SingleString;
import com.xdf.femisnsb.service.ContinuousServiceAgg;
import com.xdf.femisnsb.service.ContinuousServiceImpl;

/**   
 * @ClassName:  ContinuousController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����10:46:52   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@RestController
@CrossOrigin
@RequestMapping("/continuous")
public class ContinuousController {
	private static Logger logger = LoggerFactory.getLogger(ContinuousController.class);
	
	@Autowired
	private ContinuousServiceImpl service;
	
	@Autowired
	private ContinuousServiceAgg serviceAgg;
	
	@PostMapping("/insert")
	public int insert(@RequestBody Continuous record) {
		return service.insert(record);
	}

	@GetMapping("/deleteByPrimaryKey/{sid}")
	public int deleteByPrimaryKey(@PathVariable("sid") String sid) {
		return service.deleteByPrimaryKey(sid);
	}

	@PostMapping("/updateByPrimaryKey")
	public int updateByPrimaryKey(@RequestBody Continuous record) {
		return service.updateByPrimaryKey(record);
	}

	
	@GetMapping("/getByPrimaryKey/{sid}")
	public Continuous getByPrimaryKey(@PathVariable("sid") String sid) {
		return service.getByPrimaryKey(sid);
	}
	
	
	@GetMapping("/updateBillCode/{billSid}")
	public String updateBillCode(@PathVariable("billSid") String billSid) {
//		return serviceAgg.updateBillCode(billSid);
		return "�������Ѿ����ã�����";
	}
	
	
	/**
	 * ����·����http://localhost:8080/femisnsb/continuous/getNewBillCode/fabricOrder
	 * ��ȡ��cfgbillcode��sid='fabricOrder'�ĵ��ݵ����±��
	 * @param billSid = cfgbillcode.sid
	 * @return
	 */
	@GetMapping("/getNewBillCode/{billSid}")
	public SingleString getNewBillCode(@PathVariable("billSid") String billSid) {
		logger.info("�������еĴ������billSid=" + billSid);
		return new SingleString(service.getNewBillCode(billSid));
	}
	
	@GetMapping("/isFabricBillcodeExists/{codeid}")
	public boolean isFabricBillcodeExists(@PathVariable("codeid") String codeid) {
		return service.isFabricBillcodeExists(codeid);
	}
}
