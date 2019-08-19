package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermRoleUser;

public interface PermRoleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermRoleUser record);

    int insertSelective(PermRoleUser record);

    PermRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermRoleUser record);

    int updateByPrimaryKey(PermRoleUser record);
    
    List<PermRoleUser> selectAll();
}