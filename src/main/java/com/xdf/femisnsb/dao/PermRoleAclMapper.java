package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermRoleAcl;

public interface PermRoleAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermRoleAcl record);

    int insertSelective(PermRoleAcl record);

    PermRoleAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermRoleAcl record);

    int updateByPrimaryKey(PermRoleAcl record);
    
    List<PermRoleAcl> selectAll();
}