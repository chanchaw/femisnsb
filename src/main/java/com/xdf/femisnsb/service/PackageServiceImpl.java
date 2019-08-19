package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PackageMapper;
import com.xdf.femisnsb.model.Package;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageMapper dao;
	
	@Override
	public int insert(Package record) {
		return dao.insert(record);
	}

	@Override
	public int deleteBPK(String key) {
		return dao.deleteByPrimaryKey(key);
	}

	@Override
	public int updateBPK(Package record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public Package getBPK(String key) {
		return dao.selectByPrimaryKey(key);
	}

	@Override
	public List<Package> getAll() {
		return dao.selectAll();
	}

}
