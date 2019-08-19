package com.xdf.femisnsb.dao;

import java.util.List;

import com.xdf.femisnsb.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    List<OrderDetail> selectByMainId(Integer mainId);
    
    List<OrderDetail> insertBatch(List<OrderDetail> list);// 批量插入新记录
    void updateBatch(List<OrderDetail> list);// 批量修改
    List<OrderDetail> selectAllOrderCode();
    int saveBatch(List<OrderDetail> list);//批量保存数据：有则修改，没有的新增
    int saveOne(OrderDetail record);
    int saveOneNull(OrderDetail record);
    int saveList(List<OrderDetail> list);
}