package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.TableStyle;

public interface TableStyleMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(TableStyle record);

    int insertSelective(TableStyle record);

    TableStyle selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(TableStyle record);

    int updateByPrimaryKey(TableStyle record);
}