package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Companytitle;

public interface CompanyTitleService {
	int insert(Companytitle record);
	int deleteBPK(String key);
	int updateBPK(Companytitle record);
	Companytitle getBPK(String key);
	List<Companytitle> getAll();
}
