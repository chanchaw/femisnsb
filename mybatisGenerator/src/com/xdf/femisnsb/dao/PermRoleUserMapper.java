package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.PermRoleUser;

public interface PermRoleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermRoleUser record);

    int insertSelective(PermRoleUser record);

    PermRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermRoleUser record);

    int updateByPrimaryKey(PermRoleUser record);
}