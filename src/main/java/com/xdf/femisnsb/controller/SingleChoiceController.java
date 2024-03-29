/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  SingleChoiceController.java   
 * @Package com.xdf.femisnsb.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:57:27   
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

import com.xdf.femisnsb.model.SingleChoice;
import com.xdf.femisnsb.service.SingleChoiceServiceImpl;

/**   
 * @ClassName:  SingleChoiceController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:57:27   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@CrossOrigin
@RestController
@RequestMapping("/singleChoice")
public class SingleChoiceController {
	@Autowired
	private SingleChoiceServiceImpl service;
	
	@PostMapping("/insert")
	public void insert(@RequestBody SingleChoice record) {
		service.insert(record);
	}
	
	@GetMapping("/deleteByPrimaryKey/{sid}")
	public void deleteByPrimaryKey(@PathVariable("sid") String sid) {
		service.deleteByPrimaryKey(sid);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public void updateByPrimaryKey(@RequestBody SingleChoice record) {
		service.updateByPrimaryKey(record);
	}
	
	@GetMapping("/getByPrimaryKey/{sid}")
	public SingleChoice getByPrimaryKey(String sid) {
		return service.getByPrimaryKey(sid);
	}
	
	@GetMapping("/getChildren/{pid}")
	public List<SingleChoice> getChildren(@PathVariable("pid") Integer pid){
		return service.getChildren(pid);
	}
	
	@GetMapping("/getAll")
	public List<SingleChoice> getAll(){
		return service.getAll();
	}
}
