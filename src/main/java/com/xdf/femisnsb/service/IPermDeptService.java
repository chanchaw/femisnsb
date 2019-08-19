package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermDept;

public interface IPermDeptService {

	int insert(PermDept record);
	int deleteByPrimaryKey(Integer id);
	int updateByPrimaryKey(PermDept record);
	PermDept getByPrimaryKey(Integer id);
	
	List<PermDept> getAll();
	List<PermDept> getAllValid();
	List<PermDept> getAllInvalid();
}
