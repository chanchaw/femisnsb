package com.xdf.femisnsb.model;

public class MySQLTableCols {
	private int autoSeq;
	private String table_shema;
	private String table_name;
	private String column_name;
	private int ordinal_position;
	private String column_default;
	private String data_type;
	private String column_comment;
	
	
	public int getAutoSeq() {
		return autoSeq;
	}
	public void setAutoSeq(int autoSeq) {
		this.autoSeq = autoSeq;
	}
	public String getTable_shema() {
		return table_shema;
	}
	public void setTable_shema(String table_shema) {
		this.table_shema = table_shema;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public int getOrdinal_position() {
		return ordinal_position;
	}
	public void setOrdinal_position(int ordinal_position) {
		this.ordinal_position = ordinal_position;
	}
	public String getColumn_default() {
		return column_default;
	}
	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	@Override
	public String toString() {
		return "MySQLTableCols [autoSeq=" + autoSeq + ", table_shema=" + table_shema + ", table_name=" + table_name
				+ ", column_name=" + column_name + ", ordinal_position=" + ordinal_position + ", column_default="
				+ column_default + ", data_type=" + data_type + ", column_comment=" + column_comment + "]";
	}
	
	
	
	
	
	
}
