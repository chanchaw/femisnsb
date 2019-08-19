/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  DeliveryTypeController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午10:49:54   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午10:49:54   
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
