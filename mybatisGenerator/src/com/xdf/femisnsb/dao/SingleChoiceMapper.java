package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.SingleChoice;

public interface SingleChoiceMapper {
    int deleteByPrimaryKey(String sid);

    int insert(SingleChoice record);

    int insertSelective(SingleChoice record);

    SingleChoice selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(SingleChoice record);

    int updateByPrimaryKey(SingleChoice record);
}