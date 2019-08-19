package com.xdf.femisnsb.model;

public class ChargeUnit {
    @Override
	public String toString() {
		return "ChargeUnit [iid=" + iid + ", caption=" + caption + ", fieldname=" + fieldname + ", defaultval="
				+ defaultval + "]";
	}

	public Integer getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(Integer defaultval) {
		this.defaultval = defaultval;
	}

	private Integer iid;

    private String caption;

    private String fieldname;
    
    private Integer defaultval;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }
}