package com.xdf.femisnsb.model;

import java.util.Date;

public class ContactCategory {
    private Integer id;

    private String name;

    private Integer pid;

    private Float serialno;

    private Integer status;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}