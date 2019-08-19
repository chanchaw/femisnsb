package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.PackmannerMapper;
import com.xdf.femisnsb.model.Packmanner;

@Service
public class PackmannerServiceImpl implements PackmannerService {

	@Autowired
	private PackmannerMapper dao;
	
	@Override
	public int insert(Packmanner record) {
		return dao.insert(record);
	}

	@Override
	public int deleteBPK(String key) {
		return dao.deleteBPK(key);
	}

	@Override
	public int updateBPK(Packmanner record) {
		return dao.updateBPK(record);
	}

	@Override
	public Packmanner getBPK(String key) {
		return dao.selectBPK(key);
	}

	@Override
	public List<Packmanner> getAll() {
		return dao.selectAll();
	}

}
