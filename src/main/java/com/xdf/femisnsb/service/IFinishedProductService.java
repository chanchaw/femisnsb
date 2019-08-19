package com.xdf.femisnsb.service;

import java.util.List;
import com.xdf.femisnsb.model.FinishedProduct;

public interface IFinishedProductService {
	int insert(FinishedProduct instance);
	int deleteByPrimaryKey(String sId);
	int updateByPrimaryKey(FinishedProduct instance);
	
	FinishedProduct getByPrimaryKey(String sId);
	List<FinishedProduct> getAll();
	List<FinishedProduct> getAllValid();
	List<FinishedProduct> getAllInvalid();
	List<FinishedProduct> getAllChildren(Integer parentId);
	
	boolean isExist(String sId);
}
