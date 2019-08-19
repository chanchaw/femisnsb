package com.xdf.femisnsb.model;

import java.util.Date;

public class PermUrlStrategy {
    private String url;

    private Integer aclmoduleid;

    private String shirointerceptor;

    private Date createtime;

    private Integer roleid;

    private Integer permid;

    private String remark;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getAclmoduleid() {
        return aclmoduleid;
    }

    public void setAclmoduleid(Integer aclmoduleid) {
        this.aclmoduleid = aclmoduleid;
    }

    public String getShirointerceptor() {
        return shirointerceptor;
    }

    public void setShirointerceptor(String shirointerceptor) {
        this.shirointerceptor = shirointerceptor == null ? null : shirointerceptor.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermid() {
        return permid;
    }

    public void setPermid(Integer permid) {
        this.permid = permid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}