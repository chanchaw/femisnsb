package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.PermUrlStrategy;

public interface IPermUrlStrategyService {
	int insert(PermUrlStrategy record);
	
	int deleteByPrimaryKey(String url);
	
	int updateByPrimaryKey(PermUrlStrategy record);
	
	PermUrlStrategy getByPrimaryKey(String url);
	
	List<PermUrlStrategy> getAll();
}
