package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Companytitle;

public interface CompanytitleMapper {
    int insert(Companytitle record);

    int insertSelective(Companytitle record);
}