package com.xdf.femisnsb.model;

import java.util.Date;

public class OrderDetail {
    private Integer id;

    private Integer mainid;

    private String ordercode;

    private String oordercode;

    private String stylecode;

    private String goodsname;

    private String spec01;

    private String spec02;

    private String size;

    private String colorcode;

    private String colorname;

    private String color;

    private Float meter;

    private Float kg;

    private Float yard;

    private Float price;

    private Float amount;

    private Float platemake;

    private Float sample;

    private String remark;

    private Date createtime;

    private String creator;

    private Date updatetime;

    private String updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainid() {
        return mainid;
    }

    public void setMainid(Integer mainid) {
        this.mainid = mainid;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public String getOordercode() {
        return oordercode;
    }

    public void setOordercode(String oordercode) {
        this.oordercode = oordercode == null ? null : oordercode.trim();
    }

    public String getStylecode() {
        return stylecode;
    }

    public void setStylecode(String stylecode) {
        this.stylecode = stylecode == null ? null : stylecode.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getSpec01() {
        return spec01;
    }

    public void setSpec01(String spec01) {
        this.spec01 = spec01 == null ? null : spec01.trim();
    }

    public String getSpec02() {
        return spec02;
    }

    public void setSpec02(String spec02) {
        this.spec02 = spec02 == null ? null : spec02.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode == null ? null : colorcode.trim();
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname == null ? null : colorname.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Float getMeter() {
        return meter;
    }

    public void setMeter(Float meter) {
        this.meter = meter;
    }

    public Float getKg() {
        return kg;
    }

    public void setKg(Float kg) {
        this.kg = kg;
    }

    public Float getYard() {
        return yard;
    }

    public void setYard(Float yard) {
        this.yard = yard;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPlatemake() {
        return platemake;
    }

    public void setPlatemake(Float platemake) {
        this.platemake = platemake;
    }

    public Float getSample() {
        return sample;
    }

    public void setSample(Float sample) {
        this.sample = sample;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }
}