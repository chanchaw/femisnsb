package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PermRoleUserMapper;
import com.xdf.femisnsb.model.PermRoleUser;

@Service
public class PermRoleUserServiceImpl implements IPermRoleUserService {

	@Autowired
	private PermRoleUserMapper dao;
	
	public int insert(PermRoleUser record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermRoleUser record) {
		return dao.updateByPrimaryKey(record);
	}

	public PermRoleUser getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermRoleUser> getAll() {
		return dao.selectAll();
	}

}
