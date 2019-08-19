package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.TableStyle;

public interface ITableStyleService {
	int insert(TableStyle record);
	int deleteByPrimaryKey(Integer iid);
	int updateByPrimaryKey(TableStyle record);
	
	List<TableStyle> getAll();
	List<TableStyle> getAllValid();
	List<TableStyle> getAllInvalid();
	List<TableStyle> getSingleTable(String tableName);
	List<TableStyle> getSingleTableAll(String tableName);
}
