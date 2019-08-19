package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermDeptMapper;
import com.xdf.femisnsb.model.PermDept;

@Service
public class PermDeptServiceImpl implements IPermDeptService {

	@Autowired
	private PermDeptMapper dao;
	
	public int insert(PermDept record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermDept record) {
		return dao.updateByPrimaryKey(record);
	}

	public PermDept getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermDept> getAll() {
		return dao.selectAll();
	}

	public List<PermDept> getAllValid() {
		return dao.selectAllValid();
	}

	public List<PermDept> getAllInvalid() {
		return dao.selectAllInvalid();
	}

}
