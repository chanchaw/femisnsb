package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.OrderMain;

public interface OrderMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    OrderMain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);
}