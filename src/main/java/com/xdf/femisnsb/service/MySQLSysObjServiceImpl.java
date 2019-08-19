package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.MySQLSysObjMapper;
import com.xdf.femisnsb.model.MySQLSchema;
import com.xdf.femisnsb.model.MySQLTable;
import com.xdf.femisnsb.model.MySQLTableCols;

@Service
public class MySQLSysObjServiceImpl implements MySQLSysObjService {

	@Autowired
	private MySQLSysObjMapper dao;
	
	@Override
	public List<MySQLTableCols> getCols(MySQLSchema schema) {
		return dao.selectCols(schema);
	}

	@Override
	public List<MySQLTable> getTables(String dbname) {
		return dao.selectTables(dbname);
	}
	

}
