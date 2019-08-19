package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermRole;

public interface PermRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermRole record);

    int insertSelective(PermRole record);

    PermRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermRole record);

    int updateByPrimaryKey(PermRole record);
    
    
    List<PermRole> selectAll();
    List<PermRole> selectAllValid();
    List<PermRole> selectAllInvalid();
}