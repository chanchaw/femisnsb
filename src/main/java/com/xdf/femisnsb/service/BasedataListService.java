package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.BasedataList;

public interface BasedataListService {
    int deleteByPrimaryKey(Integer iid);

    int insert(BasedataList record);

    int insertSelective(BasedataList record);

    BasedataList getByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(BasedataList record);

    int updateByPrimaryKey(BasedataList record);
    
    List<BasedataList> getByPid(String pid);
    
    
}
