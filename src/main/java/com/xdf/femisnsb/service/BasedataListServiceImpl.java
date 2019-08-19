package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.BasedataListMapper;
import com.xdf.femisnsb.model.BasedataList;

@Service
public class BasedataListServiceImpl implements BasedataListService {

	@Autowired
	private BasedataListMapper dao;
	
	@Override
	public int deleteByPrimaryKey(Integer iid) {
		return dao.deleteByPrimaryKey(iid);
	}

	@Override
	public int insert(BasedataList record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(BasedataList record) {
		return dao.insertSelective(record);
	}

	@Override
	public BasedataList getByPrimaryKey(Integer iid) {
		return dao.selectByPrimaryKey(iid);
	}

	@Override
	public int updateByPrimaryKeySelective(BasedataList record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BasedataList record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<BasedataList> getByPid(String pid) {
		return dao.selectByPid(pid);
	}



}
