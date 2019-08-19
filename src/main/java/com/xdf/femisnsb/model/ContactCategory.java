package com.xdf.femisnsb.model;

import java.util.Date;

public class ContactCategory {
    private String sid;

    private String name;

    private Integer pid;

    private Float serialno;

	private Integer status;

    private Date createdate;
    
    private Date updatetime;
    
	private Integer visible;
    
    @Override
	public String toString() {
		return "ContactCategory [sid=" + sid + ", name=" + name + ", pid=" + pid + ", serialno=" + serialno
				+ ", status=" + status + ", createdate=" + createdate + ", updatetime=" + updatetime + ", visible="
				+ visible + ", seq=" + seq + "]";
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public float getSeq() {
		return seq;
	}

	public void setSeq(float seq) {
		this.seq = seq;
	}

	private float seq;

	
    
  
}