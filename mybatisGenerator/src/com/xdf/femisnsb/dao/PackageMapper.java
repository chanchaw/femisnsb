package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Package;

public interface PackageMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKey(Package record);
}