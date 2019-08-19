package com.xdf.femisnsb.service;

import java.util.List;
import com.xdf.femisnsb.model.JsonData;
import com.xdf.femisnsb.model.PermRoleUser;
import com.xdf.femisnsb.model.PermRoleUserFull;
import com.xdf.femisnsb.model.PermUser;
import com.xdf.femisnsb.model.PermUserPermission;

public interface PermUserService {

	int insert(PermUser instance);
	int deleteByPrimary(Integer id);
	int deleteByUserid(String userId);
	int updateByPrimaryKey(PermUser instance);
	PermUser getByPrimaryKey(Integer id);
	
	
	List<PermUser> getByUserid(String userId);
	List<PermUser> getAll();
	List<PermUser> getAllValid();
	List<PermUser> getAllInvalid();
	
	List<PermRoleUser> getRolesById(Integer id);
	List<PermRoleUser> getRolesByUserId(String userId);
	List<PermUserPermission> getAclsById(Integer id);
	List<PermUserPermission> getAclsByUserId(String userId);
	
	JsonData login(String userid,String password);
	
	List<PermRoleUserFull> getChildrenUsers(Integer roleId);
}
