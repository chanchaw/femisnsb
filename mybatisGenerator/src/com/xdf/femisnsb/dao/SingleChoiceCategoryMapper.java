package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.SingleChoiceCategory;

public interface SingleChoiceCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SingleChoiceCategory record);

    int insertSelective(SingleChoiceCategory record);

    SingleChoiceCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SingleChoiceCategory record);

    int updateByPrimaryKey(SingleChoiceCategory record);
}