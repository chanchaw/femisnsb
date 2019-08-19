package com.xdf.femisnsb.model;

import java.util.Date;

public class Companytitle {
    private String sid;

    private String oprimary;

    private Date createdate;

    private Date updatedate;

    private String updateuser;
    
    private float seq;
    
    private int isdefault;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getOprimary() {
		return oprimary;
	}

	public void setOprimary(String oprimary) {
		this.oprimary = oprimary;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public float getSeq() {
		return seq;
	}

	public void setSeq(float seq) {
		this.seq = seq;
	}

	public int getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}

	@Override
	public String toString() {
		return "Companytitle [sid=" + sid + ", oprimary=" + oprimary + ", createdate=" + createdate + ", updatedate="
				+ updatedate + ", updateuser=" + updateuser + ", seq=" + seq + ", isdefault=" + isdefault + "]";
	}
    
    
}