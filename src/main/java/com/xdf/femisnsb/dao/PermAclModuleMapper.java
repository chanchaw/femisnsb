package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermAclModule;

public interface PermAclModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermAclModule record);

    int insertSelective(PermAclModule record);

    PermAclModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermAclModule record);

    int updateByPrimaryKey(PermAclModule record);
    
    List<PermAclModule> selectAll();
    List<PermAclModule> selectAllValid();
    List<PermAclModule> selectAllInvalid();
}