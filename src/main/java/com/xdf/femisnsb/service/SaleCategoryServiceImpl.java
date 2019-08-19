package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.SaleCategoryMapper;
import com.xdf.femisnsb.model.SaleCategory;

@Service
public class SaleCategoryServiceImpl implements SaleCategoryService {

	@Autowired
	private SaleCategoryMapper dao;
	
	@Override
	public int insert(SaleCategory record) {
		return dao.insert(record);
	}

	@Override
	public int deleteBPK(String key) {
		return dao.deleteByPrimaryKey(key);
	}

	@Override
	public int updateBPK(SaleCategory record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public SaleCategory getBPK(String key) {
		return dao.selectByPrimaryKey(key);
	}

	@Override
	public List<SaleCategory> getAll() {
		return dao.selectAll();
	}

}
