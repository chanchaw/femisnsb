package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermRoleUser;

public interface IPermRoleUserService {

	int insert(PermRoleUser record);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermRoleUser record);
	PermRoleUser getByPrimaryKey(Integer id);
	
	List<PermRoleUser> getAll();
}
