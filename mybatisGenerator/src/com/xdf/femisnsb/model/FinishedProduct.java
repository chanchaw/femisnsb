package com.xdf.femisnsb.model;

import java.util.Date;

public class FinishedProduct {
    private String sid;

    private String name;

    private String specification;

    private Integer parentid;

    private Float serialno;

    private Integer status;

    private Date createdate;

    private String oprimary;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
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

    public String getOprimary() {
        return oprimary;
    }

    public void setOprimary(String oprimary) {
        this.oprimary = oprimary == null ? null : oprimary.trim();
    }
}