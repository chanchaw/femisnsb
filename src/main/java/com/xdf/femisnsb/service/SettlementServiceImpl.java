package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.SettlementMapper;
import com.xdf.femisnsb.model.Settlement;

@Service
public class SettlementServiceImpl implements SettlementService {

	@Autowired
	private SettlementMapper dao;
	@Override
	public Integer insert(Settlement record) {
		return dao.insert(record);
	}

	@Override
	public Integer deleteByPrimaryKey(String key) {
		return dao.deleteByPrimaryKey(key);
	}

	@Override
	public Integer updateByPrimaryKey(Settlement record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public Settlement getByPrimaryKey(String key) {
		return dao.selectByPrimaryKey(key);
	}

	@Override
	public List<Settlement> getAll() {
		return dao.selectAll();
	}

	@Override
	public Integer updateBPKS(Settlement record) {
		return dao.updateByPrimaryKeySelective(record);
	}

}
