package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.FinishedProductCategory;

public interface FinishedProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinishedProductCategory record);

    int insertSelective(FinishedProductCategory record);

    FinishedProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinishedProductCategory record);

    int updateByPrimaryKey(FinishedProductCategory record);
}