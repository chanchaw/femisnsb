package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.DeliveryType;

public interface DeliveryTypeMapper {
    int deleteByPrimaryKey(String sid);

    int insert(DeliveryType record);

    int insertSelective(DeliveryType record);

    DeliveryType selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(DeliveryType record);

    int updateByPrimaryKey(DeliveryType record);
}