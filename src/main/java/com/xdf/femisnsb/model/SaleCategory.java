package com.xdf.femisnsb.model;

import java.util.Date;

public class SaleCategory {
    private String sid;

    private String oprimary;

    private Float seq;

    private Date createdate;

    private Date updatedate;

    private String updateuser;

    private Integer isdefault;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getOprimary() {
        return oprimary;
    }

    public void setOprimary(String oprimary) {
        this.oprimary = oprimary == null ? null : oprimary.trim();
    }

    public Float getSeq() {
        return seq;
    }

    public void setSeq(Float seq) {
        this.seq = seq;
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
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

	@Override
	public String toString() {
		return "SaleCategory [sid=" + sid + ", oprimary=" + oprimary + ", seq=" + seq + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + ", updateuser=" + updateuser + ", isdefault=" + isdefault + "]";
	}
    
    
}