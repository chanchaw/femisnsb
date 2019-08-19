package com.xdf.femisnsb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MySQLSchema {
	private String table_schema;
	private String table_name;
	public String getTable_schema() {
		return table_schema;
	}
	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	@Override
	public String toString() {
		return "MySQLSchema [table_schema=" + table_schema + ", table_name=" + table_name + "]";
	}
	
	
	
}
