package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> selectAll();
    List<Employee> selectChildren(Integer pid);
}