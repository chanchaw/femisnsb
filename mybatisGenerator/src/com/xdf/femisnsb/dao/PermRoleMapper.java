package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.PermRole;

public interface PermRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermRole record);

    int insertSelective(PermRole record);

    PermRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermRole record);

    int updateByPrimaryKey(PermRole record);
}