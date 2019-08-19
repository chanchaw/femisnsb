package com.xdf.femisnsb.dao;

import com.xdf.femisnsb.model.Continuous;
import com.xdf.femisnsb.model.OrderMain;

public interface ContinuousMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Continuous record);

    int insertSelective(Continuous record);

    Continuous selectByPrimaryKey(String sid);
    Continuous selectPrepartLast(String prePart);

    int updateByPrimaryKeySelective(Continuous record);

    int updateByPrimaryKey(Continuous record);
    OrderMain isFabricBillcodeExists(String codeid);
}