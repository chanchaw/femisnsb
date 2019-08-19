package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermDept;

public interface PermDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermDept record);

    int insertSelective(PermDept record);

    PermDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermDept record);

    int updateByPrimaryKey(PermDept record);
    
    List<PermDept> selectAll();
    List<PermDept> selectAllValid();
    List<PermDept> selectAllInvalid();
}