package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Packmanner;

public interface PackmannerService {
	int insert(Packmanner record);
	int deleteBPK(String key);
	int updateBPK(Packmanner record);
	Packmanner getBPK(String key);
	List<Packmanner> getAll();
	
}
