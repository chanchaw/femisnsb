package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Packmanner;

public interface PackmannerMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Packmanner record);

    int insertSelective(Packmanner record);

    Packmanner selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Packmanner record);

    int updateByPrimaryKey(Packmanner record);
}