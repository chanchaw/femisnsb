package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.ContactCategory;

public interface ContactCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactCategory record);

    int insertSelective(ContactCategory record);

    ContactCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactCategory record);

    int updateByPrimaryKey(ContactCategory record);
}