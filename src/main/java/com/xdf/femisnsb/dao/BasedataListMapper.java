package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.BasedataList;

public interface BasedataListMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(BasedataList record);

    int insertSelective(BasedataList record);

    BasedataList selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(BasedataList record);

    int updateByPrimaryKey(BasedataList record);
    
    List<BasedataList> selectByPid(String pid);
}