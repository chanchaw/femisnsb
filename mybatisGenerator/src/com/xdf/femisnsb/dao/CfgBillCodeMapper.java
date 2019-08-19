package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.CfgBillCode;

public interface CfgBillCodeMapper {
    int deleteByPrimaryKey(String sid);

    int insert(CfgBillCode record);

    int insertSelective(CfgBillCode record);

    CfgBillCode selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(CfgBillCode record);

    int updateByPrimaryKey(CfgBillCode record);
}