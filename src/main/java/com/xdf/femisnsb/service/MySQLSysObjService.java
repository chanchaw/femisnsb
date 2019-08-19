package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.MySQLSchema;
import com.xdf.femisnsb.model.MySQLTable;
import com.xdf.femisnsb.model.MySQLTableCols;

public interface MySQLSysObjService {
	List<MySQLTableCols> getCols(MySQLSchema schema);
	List<MySQLTable> getTables(String dbname);
}
