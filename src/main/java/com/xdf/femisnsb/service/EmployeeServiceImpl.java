package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.EmployeeMapper;
import com.xdf.femisnsb.model.Employee;

/**   
 * @ClassName:  EmployeeServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午7:44:49   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper dao;
	
	public void insert(Employee record) {
		dao.insert(record);
	}

	public void deleteByPrimaryKey(String sid) {
		dao.deleteByPrimaryKey(sid);
	}

	public void updateByPrimaryKey(Employee record) {
		dao.updateByPrimaryKey(record);
	}

	public Employee getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}

	public List<Employee> getAll() {
		return dao.selectAll();
	}

	public List<Employee> getChildren(Integer pid) {
		return dao.selectChildren(pid);
	}

}
