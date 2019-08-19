package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.ContactCompany;

public interface ContactCompanyMapper {
    int insert(ContactCompany record);

    int insertSelective(ContactCompany record);
    
    int deleteByPrimaryKey(String sid);
    
    int updateByPrimaryKey(ContactCompany record);
    int updateSelective(ContactCompany record);
    
    ContactCompany selectByPrimaryKey(String sid);
    
    List<ContactCompany> selectAll();
    List<ContactCompany> selectAllValid();
    List<ContactCompany> selectAllInvalid();
    List<ContactCompany> selectChildren(Integer parentid);
}