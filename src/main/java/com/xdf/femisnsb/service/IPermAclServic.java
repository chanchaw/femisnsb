package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermAcl;

public interface IPermAclServic {

	int insert(PermAcl record);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermAcl record);
	PermAcl getByPrimaryKey(Integer id);
	
	List<PermAcl> getAll();
	List<PermAcl> getAllValid();
	List<PermAcl> getAllInvalid();
}
