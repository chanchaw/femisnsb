package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Package;;

public interface PackageService {
	int insert(Package record);
	int deleteBPK(String key);
	int updateBPK(Package record);
	Package getBPK(String key);
	List<Package> getAll();
}
