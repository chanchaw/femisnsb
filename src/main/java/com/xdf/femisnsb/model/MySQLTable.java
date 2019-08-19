package com.xdf.femisnsb.model;

public class MySQLTable {
	private int autoSeq;
	private String table_schema;
	private String table_name;
	private String engine;
	private int table_rows;
	private String table_collation;
	private String table_comment;
	
	
	public int getAutoSeq() {
		return autoSeq;
	}
	public void setAutoSeq(int autoSeq) {
		this.autoSeq = autoSeq;
	}
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
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public int getTable_rows() {
		return table_rows;
	}
	public void setTable_rows(int table_rows) {
		this.table_rows = table_rows;
	}
	public String getTable_collation() {
		return table_collation;
	}
	public void setTable_collation(String table_collation) {
		this.table_collation = table_collation;
	}
	public String getTable_comment() {
		return table_comment;
	}
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
	@Override
	public String toString() {
		return "MySQLTable [autoSeq=" + autoSeq + ", table_schema=" + table_schema + ", table_name=" + table_name
				+ ", engine=" + engine + ", table_rows=" + table_rows + ", table_collation=" + table_collation
				+ ", table_comment=" + table_comment + "]";
	}
	
	
	
}
