package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.CfgBillCode;

public interface CfgBillCodeMapper {
	int insert(CfgBillCode record);
    int deleteByPrimaryKey(String sid);
    int updateByPrimaryKey(CfgBillCode record);
    CfgBillCode selectByPrimaryKey(String sid);
}