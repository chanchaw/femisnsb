package com.xdf.femisnsb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdf.femisnsb.dao.PermUrlStrategyMapper;
import com.xdf.femisnsb.model.PermUrlStrategy;

@Service
public class PermUrlStrategyServiceImpl implements IPermUrlStrategyService {

	@Autowired
	private PermUrlStrategyMapper dao;
	
	public int insert(PermUrlStrategy record) {
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(String url) {
		return dao.deleteByPrimaryKey(url);
	}

	public int updateByPrimaryKey(PermUrlStrategy record) {
		return dao.updateByPrimaryKey(record);
	}

	public PermUrlStrategy getByPrimaryKey(String url) {
		return dao.selectByPrimaryKey(url);
	}

	public List<PermUrlStrategy> getAll() {
		return dao.selectAll();
	}

}
