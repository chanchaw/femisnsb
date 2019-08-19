package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.Packmanner;

public interface PackmannerMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Packmanner record);

    int insertSelective(Packmanner record);

    Packmanner selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Packmanner record);

    int updateByPrimaryKey(Packmanner record);
    
    
    
    int deleteBPK(String key);
    int updateBPK(Packmanner record);
    Packmanner selectBPK(String key);
    List<Packmanner> selectAll();
}