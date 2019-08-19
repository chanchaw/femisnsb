package com.xdf.femisnsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.ContactCompanyMapper;
import com.xdf.femisnsb.model.ContactCompany;

@Service
public class ContactCompanyVerServiceImp implements ContactCompanyVerService {

	@Autowired
	private ContactCompanyMapper dao;
	
	@Override
	public int insert(ContactCompany record) {
		return dao.insert(record);
	}

	@Override
	public int deleteByForeignKey(String sid) {
		return dao.deleteByPrimaryKey(sid);
	}

}
