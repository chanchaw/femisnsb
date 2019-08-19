package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Employee;

/**   
 * @ClassName:  EmployeeService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午7:43:19   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface EmployeeService {
	void insert(Employee record);
	void deleteByPrimaryKey(String sid);
	void updateByPrimaryKey(Employee record);
	Employee getByPrimaryKey(String sid);
	
	List<Employee> getAll();
	List<Employee> getChildren(Integer pid);
}
