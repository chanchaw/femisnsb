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
    
    List<OrderDetail> insertBatch(List<OrderDetail> list);// ���������¼�¼
    void updateBatch(List<OrderDetail> list);// �����޸�
    List<OrderDetail> selectAllOrderCode();
    int saveBatch(List<OrderDetail> list);//�����������ݣ������޸ģ�û�е�����
    int saveOne(OrderDetail record);
    int saveOneNull(OrderDetail record);
    int saveList(List<OrderDetail> list);
}