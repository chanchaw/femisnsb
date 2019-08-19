package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}