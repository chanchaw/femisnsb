package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermAclModule;

public interface IPermAclModuleService {
	int insert(PermAclModule instance);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermAclModule instance);
	PermAclModule getByPrimaryKey(Integer id);
	
	List<PermAclModule> getAll();
	List<PermAclModule> getAllValid();
	List<PermAclModule> getAllInvalid();
}
