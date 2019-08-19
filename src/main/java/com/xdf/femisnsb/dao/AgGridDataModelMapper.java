package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.AgGridDataModel;

public interface AgGridDataModelMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(AgGridDataModel record);

    int insertSelective(AgGridDataModel record);

    AgGridDataModel selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(AgGridDataModel record);

    int updateByPrimaryKey(AgGridDataModel record);
    
    List<AgGridDataModel> selectAll();
}