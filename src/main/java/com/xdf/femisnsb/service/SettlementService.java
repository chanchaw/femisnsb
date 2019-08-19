package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Settlement;;

public interface SettlementService {

	Integer insert(Settlement record);
	Integer deleteByPrimaryKey(String key);
	Integer updateByPrimaryKey(Settlement record);
	Integer updateBPKS(Settlement record);
	Settlement getByPrimaryKey(String key);
	List<com.xdf.femisnsb.model.Settlement> getAll();
}
