package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermRoleAcl;

public interface IPermRoleAclService {
	int insert(PermRoleAcl record);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermRoleAcl record);
	PermRoleAcl getByPrimaryKey(Integer id);
	
	List<PermRoleAcl> getAll();
}
