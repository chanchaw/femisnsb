package com.xdf.femisnsb.model;

import java.util.Date;

public class FinishedProductCategory {
    @Override
	public String toString() {
		return "FinishedProductCategory [id=" + id + ", title=" + title + ", parentid=" + parentid + ", serialno="
				+ serialno + ", status=" + status + ", createdate=" + createdate + ", oprimary=" + oprimary + "]";
	}

	private Integer id;

    private String title;

    private Integer parentid;

    private Float serialno;

    private Integer status;

    private Date createdate;

    private Integer oprimary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Float getSerialno() {
        return serialno;
    }

    public void setSerialno(Float serialno) {
        this.serialno = serialno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getOprimary() {
        return oprimary;
    }

    public void setOprimary(Integer oprimary) {
        this.oprimary = oprimary;
    }
    
    
}