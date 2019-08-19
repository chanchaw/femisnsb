package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.SaleCategory;

public interface SaleCategoryMapper {
    int deleteByPrimaryKey(String sid);

    int insert(SaleCategory record);

    int insertSelective(SaleCategory record);

    SaleCategory selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(SaleCategory record);

    int updateByPrimaryKey(SaleCategory record);
    
    List<SaleCategory> selectAll();
}