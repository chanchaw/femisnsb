package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermRoleAclMapper;
import com.xdf.femisnsb.model.PermRoleAcl;

@Service
public class PermRoleAclServiceImpl implements IPermRoleAclService {

	@Autowired
	private PermRoleAclMapper dao;
	
	public int insert(PermRoleAcl record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermRoleAcl record) {
		return dao.updateByPrimaryKey(record);
	}

	public PermRoleAcl getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermRoleAcl> getAll() {
		return dao.selectAll();
	}

}
