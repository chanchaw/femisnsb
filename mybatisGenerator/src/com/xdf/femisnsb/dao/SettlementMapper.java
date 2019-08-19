package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Settlement;

public interface SettlementMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Settlement record);

    int insertSelective(Settlement record);

    Settlement selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Settlement record);

    int updateByPrimaryKey(Settlement record);
}