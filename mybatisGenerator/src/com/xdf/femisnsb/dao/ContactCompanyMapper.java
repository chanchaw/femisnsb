package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.ContactCompany;

public interface ContactCompanyMapper {
    int insert(ContactCompany record);

    int insertSelective(ContactCompany record);
}