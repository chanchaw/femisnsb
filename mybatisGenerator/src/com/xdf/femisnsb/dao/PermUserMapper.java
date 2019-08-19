package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.PermUser;

public interface PermUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermUser record);

    int insertSelective(PermUser record);

    PermUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermUser record);

    int updateByPrimaryKey(PermUser record);
}