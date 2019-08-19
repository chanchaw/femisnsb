package com.xdf.femisnsb.model;

public class Continuous {
    private String sid;

    private String prepart;

    private Integer increament;

    private String suffix;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getPrepart() {
        return prepart;
    }

    public void setPrepart(String prepart) {
        this.prepart = prepart == null ? null : prepart.trim();
    }

    public Integer getIncreament() {
        return increament;
    }

    public void setIncreament(Integer increament) {
        this.increament = increament;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }
}