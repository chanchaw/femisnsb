package com.xdf.femisnsb.model;

public class SingleChoice {
    private String sid;

    private Integer pid;

    private String oprimary;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOprimary() {
        return oprimary;
    }

    public void setOprimary(String oprimary) {
        this.oprimary = oprimary == null ? null : oprimary.trim();
    }
}