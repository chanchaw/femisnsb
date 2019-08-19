package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.PermAcl;

public interface PermAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermAcl record);

    int insertSelective(PermAcl record);

    PermAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermAcl record);

    int updateByPrimaryKey(PermAcl record);
}