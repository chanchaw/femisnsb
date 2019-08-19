package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.MySQLSchema;
import com.xdf.femisnsb.model.MySQLTable;
import com.xdf.femisnsb.model.MySQLTableCols;

public interface MySQLSysObjMapper {
	List<MySQLTableCols> selectCols(MySQLSchema schema);
	List<MySQLTable> selectTables(String dbname);
}
