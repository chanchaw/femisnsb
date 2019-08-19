package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.ChargeUnit;

public interface ChargeUnitMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(ChargeUnit record);

    int insertSelective(ChargeUnit record);

    ChargeUnit selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(ChargeUnit record);

    int updateByPrimaryKey(ChargeUnit record);
}