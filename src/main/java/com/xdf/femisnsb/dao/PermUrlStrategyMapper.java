package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.PermUrlStrategy;

public interface PermUrlStrategyMapper {
    int deleteByPrimaryKey(String url);

    int insert(PermUrlStrategy record);

    int insertSelective(PermUrlStrategy record);

    PermUrlStrategy selectByPrimaryKey(String url);

    int updateByPrimaryKeySelective(PermUrlStrategy record);

    int updateByPrimaryKey(PermUrlStrategy record);
    
    List<PermUrlStrategy> selectAll();
}