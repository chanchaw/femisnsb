package com.xdf.femisnsb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdf.utils.BillCodeUtils;

/**   
 * @ClassName:  BillCodeController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��1�� ����10:15:56   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/billCode")
public class BillCodeController {

	private BillCodeUtils service = new BillCodeUtils();
	
//	@GetMapping("/getNewBillCode/{billSid}")
//	private String getNewBillCode(@PathVariable("billSid") String billSid) {
//		return service.getNewBillCode(billSid);
//	}
}
