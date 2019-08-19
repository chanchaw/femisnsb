package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.Companytitle;

public interface CompanytitleMapper {
    int insert(Companytitle record);

    int insertSelective(Companytitle record);
    
    int deleteBPK(String key);
    
    int updateBPK(Companytitle record);
    
    Companytitle selectByPrimaryKey(String key);
    List<Companytitle> selectAll();
}