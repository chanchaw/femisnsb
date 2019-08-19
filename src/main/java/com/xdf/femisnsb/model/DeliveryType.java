package com.xdf.femisnsb.model;

import java.util.Date;

public class DeliveryType {
    private String sid;

    private String oprimary;

    private Date createdate;
    
    private Date updatedate;
    
    private String updateuser;

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

	@Override
	public String toString() {
		return "DeliveryType [sid=" + sid + ", oprimary=" + oprimary + ", createdate=" + createdate + ", updatedate="
				+ updatedate + ", updateuser=" + updateuser + "]";
	}
	
	
}