package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.ContactCompanyVer;

public interface ContactCompanyVerMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(ContactCompanyVer record);

    int insertSelective(ContactCompanyVer record);

    ContactCompanyVer selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(ContactCompanyVer record);

    int updateByPrimaryKey(ContactCompanyVer record);
}