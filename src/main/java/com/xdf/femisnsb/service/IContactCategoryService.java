package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.ContactCategory;

public interface IContactCategoryService {
	int insert(ContactCategory record);
	int deleteByPrimary(String sid);
	int updateByPrimary(ContactCategory record);
	ContactCategory getByPrimary(String sid);
	ContactCategory getByName(String name);
	ContactCategory getByTitle(String title);
	List<ContactCategory> getAll();
	List<ContactCategory> getAllValid();
	String getCategoryNames(String categories);
}
