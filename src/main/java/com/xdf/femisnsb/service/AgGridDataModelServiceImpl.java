package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.AgGridDataModelMapper;
import com.xdf.femisnsb.model.AgGridDataModel;

@Service
public class AgGridDataModelServiceImpl implements AgGridDataModelService {
	
	@Autowired
	private AgGridDataModelMapper dao;

	@Override
	public List<AgGridDataModel> getAll() {
		return dao.selectAll();
	}

}
