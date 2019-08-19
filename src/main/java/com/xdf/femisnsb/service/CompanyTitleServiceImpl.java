package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.CompanytitleMapper;
import com.xdf.femisnsb.model.Companytitle;

@Service
public class CompanyTitleServiceImpl implements CompanyTitleService {

	@Autowired
	private CompanytitleMapper dao;
	
	@Override
	public int insert(Companytitle record) {
		return dao.insert(record);
	}

	@Override
	public int deleteBPK(String key) {
		return dao.deleteBPK(key);
	}

	@Override
	public int updateBPK(Companytitle record) {
		return dao.updateBPK(record);
	}

	@Override
	public Companytitle getBPK(String key) {
		return dao.selectByPrimaryKey(key);
	}

	@Override
	public List<Companytitle> getAll() {
		return dao.selectAll();
	}

}
