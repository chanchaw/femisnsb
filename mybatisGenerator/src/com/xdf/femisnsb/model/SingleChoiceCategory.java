package com.xdf.femisnsb.model;

public class SingleChoiceCategory {
    private Integer id;

    private String name;

    private Integer pid;

    private Integer oprimary;

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

    public Integer getOprimary() {
        return oprimary;
    }

    public void setOprimary(Integer oprimary) {
        this.oprimary = oprimary;
    }
}