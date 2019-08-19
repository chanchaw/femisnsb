package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.FinishedProductMapper;
import com.xdf.femisnsb.model.FinishedProduct;

@Service
public class FinishedProductServiceImpl implements IFinishedProductService {

	@Autowired
	private FinishedProductMapper dao;
	
	public int insert(FinishedProduct instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimaryKey(String sId) {
		return dao.deleteByPrimaryKey(sId);
	}

	public int updateByPrimaryKey(FinishedProduct instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public FinishedProduct getByPrimaryKey(String sId) {
		return dao.selectByPrimaryKey(sId);
	}

	public List<FinishedProduct> getAll() {
		return dao.selectAll();
	}

	public List<FinishedProduct> getAllValid() {
		return dao.selectAllValid();
	}

	public List<FinishedProduct> getAllInvalid() {
		return dao.selectAllInvalid();
	}

	public boolean isExist(String sId) {
		FinishedProduct fp = getByPrimaryKey(sId);
		if(fp ==null ) {
			return false;
		}else {
			return true;
		}
	}

	public List<FinishedProduct> getAllChildren(Integer parentId) {
		return dao.selectAllChildren(parentId);
	}

}
