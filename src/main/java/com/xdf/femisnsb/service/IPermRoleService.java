package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermRole;

public interface IPermRoleService {

	int insert(PermRole instance);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermRole instance);
	PermRole getByPrimaryKey(Integer id);
	
	List<PermRole> getAll();
	List<PermRole> getAllValid();
	List<PermRole> getAllInvalid();
}
