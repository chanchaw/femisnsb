package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.FinishedProductCategory;

public interface FinishedProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinishedProductCategory record);

    int insertSelective(FinishedProductCategory record);

    FinishedProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinishedProductCategory record);

    Integer updateByPrimaryKey(FinishedProductCategory record);
    
//    �������Զ���ѯ
    List<FinishedProductCategory> selectAll();
    List<FinishedProductCategory> selectAllValid();
    List<FinishedProductCategory> selectAllInvalid();
    
    List<FinishedProductCategory> selectByName(String name);
}