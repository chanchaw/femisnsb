package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermAclModuleMapper;
import com.xdf.femisnsb.model.PermAclModule;

@Service
public class PermAclModuleServiceImple implements IPermAclModuleService {

	@Autowired
	private PermAclModuleMapper dao;
	
	public int insert(PermAclModule instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermAclModule instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public PermAclModule getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermAclModule> getAll() {
		return dao.selectAll();
	}

	public List<PermAclModule> getAllValid() {
		return dao.selectAllValid();
	}

	public List<PermAclModule> getAllInvalid() {
		return dao.selectAllInvalid();
	}

}
