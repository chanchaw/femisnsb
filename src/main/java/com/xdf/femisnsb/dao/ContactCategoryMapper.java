package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.ContactCategory;

public interface ContactCategoryMapper {
    int deleteByPrimaryKey(String sid);

    int insert(ContactCategory record);

    int insertSelective(ContactCategory record);

    ContactCategory selectByPrimaryKey(String sid);
    ContactCategory selectByName(String name);
    ContactCategory selectByTitle(String title);

    int updateByPrimaryKeySelective(ContactCategory record);

    int updateByPrimaryKey(ContactCategory record);
    
    List<ContactCategory> selectAll();
    List<ContactCategory> selectAllValid();
    
    String getCategoryNames(String categories);
}