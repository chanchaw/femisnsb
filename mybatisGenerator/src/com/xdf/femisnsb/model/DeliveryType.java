package com.xdf.femisnsb.model;

public class DeliveryType {
    private String sid;

    private String oprimary;

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
}