package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.TableStyleMapper;
import com.xdf.femisnsb.model.TableStyle;

@Service
public class TableStyleServiceImpl implements ITableStyleService {

	@Autowired
	private TableStyleMapper dao;
	
	public int insert(TableStyle instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimaryKey(Integer iid) {
		return dao.deleteByPrimaryKey(iid);
	}

	public int updateByPrimaryKey(TableStyle instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public List<TableStyle> getAll() {
		return dao.selectAll();
	}

	public List<TableStyle> getAllValid() {
		return dao.selectAllValid();
	}

	public List<TableStyle> getAllInvalid() {
		return dao.selectAllInvalid();
	}

	public List<TableStyle> getSingleTable(String tableName) {
		return dao.selectSingleTable(tableName);
	}

	@Override
	public List<TableStyle> getSingleTableAll(String tableName) {
		return dao.selectSingleTableAll(tableName);
	}


}
