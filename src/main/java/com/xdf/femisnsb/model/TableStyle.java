package com.xdf.femisnsb.model;

import java.util.Date;

public class TableStyle {

	private Integer iid;
    private String dbname;
    private String tablename;
    private String fieldname;
    private String caption;
    private Double colwidth;
    private Integer alignment;
    private String backcolor;
    private String forecolor;
    private Integer locked;
	private Integer isquantity;
    private Integer sole;
    private Integer notnull;
    private Date createdate;
    private Integer visible;
	private Double seq;
    private Integer fixed;
	private String dataType;
	private String widthpercent;
	private String aligncaption;
	private String aligncontent;
	private String display;
	private String widthpx;
	private float width;
	private int immutable;
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Double getColwidth() {
		return colwidth;
	}
	public void setColwidth(Double colwidth) {
		this.colwidth = colwidth;
	}
	public Integer getAlignment() {
		return alignment;
	}
	public void setAlignment(Integer alignment) {
		this.alignment = alignment;
	}
	public String getBackcolor() {
		return backcolor;
	}
	public void setBackcolor(String backcolor) {
		this.backcolor = backcolor;
	}
	public String getForecolor() {
		return forecolor;
	}
	public void setForecolor(String forecolor) {
		this.forecolor = forecolor;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Integer getIsquantity() {
		return isquantity;
	}
	public void setIsquantity(Integer isquantity) {
		this.isquantity = isquantity;
	}
	public Integer getSole() {
		return sole;
	}
	public void setSole(Integer sole) {
		this.sole = sole;
	}
	public Integer getNotnull() {
		return notnull;
	}
	public void setNotnull(Integer notnull) {
		this.notnull = notnull;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getVisible() {
		return visible;
	}
	public void setVisible(Integer visible) {
		this.visible = visible;
	}
	public Double getSeq() {
		return seq;
	}
	public void setSeq(Double seq) {
		this.seq = seq;
	}
	public Integer getFixed() {
		return fixed;
	}
	public void setFixed(Integer fixed) {
		this.fixed = fixed;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getWidthpercent() {
		return widthpercent;
	}
	public void setWidthpercent(String widthpercent) {
		this.widthpercent = widthpercent;
	}
	public String getAligncaption() {
		return aligncaption;
	}
	public void setAligncaption(String aligncaption) {
		this.aligncaption = aligncaption;
	}
	public String getAligncontent() {
		return aligncontent;
	}
	public void setAligncontent(String aligncontent) {
		this.aligncontent = aligncontent;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getWidthpx() {
		return widthpx;
	}
	public void setWidthpx(String widthpx) {
		this.widthpx = widthpx;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public int getImmutable() {
		return immutable;
	}
	public void setImmutable(int immutable) {
		this.immutable = immutable;
	}
	@Override
	public String toString() {
		return "TableStyle [iid=" + iid + ", dbname=" + dbname + ", tablename=" + tablename + ", fieldname=" + fieldname
				+ ", caption=" + caption + ", colwidth=" + colwidth + ", alignment=" + alignment + ", backcolor="
				+ backcolor + ", forecolor=" + forecolor + ", locked=" + locked + ", isquantity=" + isquantity
				+ ", sole=" + sole + ", notnull=" + notnull + ", createdate=" + createdate + ", visible=" + visible
				+ ", seq=" + seq + ", fixed=" + fixed + ", dataType=" + dataType + ", widthpercent=" + widthpercent
				+ ", aligncaption=" + aligncaption + ", aligncontent=" + aligncontent + ", display=" + display
				+ ", widthpx=" + widthpx + ", width=" + width + ", immutable=" + immutable + "]";
	}
	
	
	
}