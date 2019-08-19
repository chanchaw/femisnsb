package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.SaleCategory;

public interface SaleCategoryService {
	int insert(SaleCategory record);
	int deleteBPK(String key);
	int updateBPK(SaleCategory record);
	SaleCategory getBPK(String key);
	List<SaleCategory> getAll();
}
