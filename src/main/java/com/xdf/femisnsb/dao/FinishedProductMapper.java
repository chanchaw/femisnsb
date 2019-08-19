package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.FinishedProduct;

public interface FinishedProductMapper {
    int deleteByPrimaryKey(String sid);

    int insert(FinishedProduct record);

    int insertSelective(FinishedProduct record);

    FinishedProduct selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(FinishedProduct record);

    int updateByPrimaryKey(FinishedProduct record);
    
    List<FinishedProduct> selectAll();
    List<FinishedProduct> selectAllValid();
    List<FinishedProduct> selectAllInvalid();
    List<FinishedProduct> selectAllChildren(Integer parentId);
}