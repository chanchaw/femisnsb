package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Continuous;

public interface ContinuousMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Continuous record);

    int insertSelective(Continuous record);

    Continuous selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Continuous record);

    int updateByPrimaryKey(Continuous record);
}