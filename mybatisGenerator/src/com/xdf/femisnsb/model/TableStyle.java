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

    private Integer hide;

    private Integer notnull;

    private Date createdate;

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
        this.dbname = dbname == null ? null : dbname.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
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
        this.backcolor = backcolor == null ? null : backcolor.trim();
    }

    public String getForecolor() {
        return forecolor;
    }

    public void setForecolor(String forecolor) {
        this.forecolor = forecolor == null ? null : forecolor.trim();
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

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
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
}