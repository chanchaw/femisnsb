package com.xdf.femisnsb.dao;

import java.util.List;
import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.model.PermRoleUserFull;
import com.xdf.femisnsb.model.PermUser;
import com.xdf.femisnsb.model.PermUserPermission;

public interface PermUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermUser record);

    int insertSelective(PermUser record);

    PermUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermUser record);

    int updateByPrimaryKey(PermUser record);
    
    List<PermUser> selectByUserid(String userId);
    List<PermUser> selectAll();
    List<PermUser> selectAllValid();
    List<PermUser> selectAllInvalid();
    
    List<PermRoleUser> selectRolesById(Integer id);
    List<PermRoleUser> selectRolesByUserId(String userId);
    List<PermUserPermission> selectAclsById(Integer id);
    List<PermUserPermission> selectAclsByUserId(String userId);
    
    List<PermRoleUserFull> selectChildrenUsers(Integer roleId);
}