package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.OrderMain;

public interface OrderMainMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(OrderMain record);//向DB中插入行后返回自增的 主键
    int insertSelective(OrderMain record);
    int updateByPrimaryKeySelective(OrderMain record);
    int updateByPrimaryKey(OrderMain record);
    
    int deleteBPK(Integer id);
    int deleteBPKImpl(Integer id);
    int updateBPK(OrderMain record);
    
    OrderMain selectBPK(Integer id);
    OrderMain selectByPrimaryKey(Integer id);
    OrderMain selectByCodeid(String codeid);
    OrderMain selectPrevious(Integer id);
    OrderMain selectNext(Integer id);
    OrderMain selectFirst();
    OrderMain selectLast();
    
    List<OrderMain> selectAll();
    
    List<OrderMain> isCodeidExists(String codeid);
}