package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermAclMapper;
import com.xdf.femisnsb.model.PermAcl;

@Service
public class PermAclServicImpl implements IPermAclServic {

	@Autowired
	private PermAclMapper dao;
	
	public int insert(PermAcl record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermAcl record) {
		return dao.updateByPrimaryKey(record);
	}

	public PermAcl getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermAcl> getAll() {
		return dao.selectAll();
	}

	public List<PermAcl> getAllValid() {
		return dao.selectAllValid();
	}

	public List<PermAcl> getAllInvalid() {
		return dao.selectAllInvalid();
	}

}
