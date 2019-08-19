package com.xdf.femisnsb.model;

public class CfgBillCode {
    private String sid;

    private String name;

    private String prefix;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer increase;

    private String suffix;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getIncrease() {
        return increase;
    }

    public void setIncrease(Integer increase) {
        this.increase = increase;
    }

    public String getSuffix() {
        return suffix == null?"":suffix.toString();
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

	@Override
	public String toString() {
		return "CfgBillCode [sid=" + sid + ", name=" + name + ", prefix=" + prefix + ", year=" + year + ", month="
				+ month + ", day=" + day + ", increase=" + increase + ", suffix=" + suffix + "]";
	}
    
    
    
}