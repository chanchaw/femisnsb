package com.xdf.femisnsb.service;

import com.xdf.femisnsb.model.ContactCompany;

public interface ContactCompanyVerService {
	int insert(ContactCompany record);
	
	int deleteByForeignKey(String sid);
	
}
