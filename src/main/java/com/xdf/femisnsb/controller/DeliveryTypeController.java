/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  DeliveryTypeController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:49:54   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
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
import com.xdf.femisnsb.model.DeliveryType;
import com.xdf.femisnsb.service.DeliveryTypeServiceImple;

/**   
 * @ClassName:  DeliveryTypeController   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:49:54   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@RestController
@CrossOrigin
@RequestMapping("/deliveryType")
public class DeliveryTypeController {
	@Autowired
	private DeliveryTypeServiceImple service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody DeliveryType record) {
		service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{sid}")
	public void deleteByPrimaryKey(String sid) {
		service.deleteByPrimaryKey(sid);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public void updateByPrimaryKey(@RequestBody DeliveryType record) {
		service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimary/{sid}")
	public DeliveryType getByPrimaryKey(@PathVariable("sid") String sid) {
		return service.getByPrimaryKey(sid);
	}
	
	@GetMapping("/getAll")
	public List<DeliveryType> getAll(){
		return service.getAll();
	}
	
	
}
