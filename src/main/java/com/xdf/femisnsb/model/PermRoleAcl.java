package com.xdf.femisnsb.model;

import java.util.Date;
import lombok.ToString;


@ToString
public class PermRoleAcl {
    public String getAclModuleName() {
		return aclModuleName;
	}

	public void setAclModuleName(String aclModuleName) {
		this.aclModuleName = aclModuleName;
	}

	public String getAclCode() {
		return aclCode;
	}

	public void setAclCode(String aclCode) {
		this.aclCode = aclCode;
	}

	public String getAclName() {
		return aclName;
	}

	public void setAclName(String aclName) {
		this.aclName = aclName;
	}

	private Integer id;

    private Integer roleid;

    private Integer aclid;

    private String operator;

    private Date operatetime;

    private String operateip;
    
    private String aclModuleName;
    private String aclCode;
    private String aclName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getAclid() {
        return aclid;
    }

    public void setAclid(Integer aclid) {
        this.aclid = aclid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }
}