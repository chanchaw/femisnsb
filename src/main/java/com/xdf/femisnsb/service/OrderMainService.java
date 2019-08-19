package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.OrderMain;

/**   
 * @ClassName:  OrderMainService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����12:19:54   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface OrderMainService {
	int insert(OrderMain record);// ������������
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(OrderMain record);
    
    int deleteBPK(Integer id);
    int deleteBPKImpl(Integer id);
    int updateBPK(OrderMain record);
    OrderMain selectBPK(Integer id);
    
    OrderMain getByPrimaryKey(Integer id);
    OrderMain getPrevious(Integer id);
    OrderMain getNext(Integer id);
    OrderMain getFirst();
    OrderMain getLast();
    OrderMain getByCodeid(String codeid);
    
    List<OrderMain> getAll();
    List<String> getAllOrderCode();
    int save(OrderMain record);// ���ز���������
    
    boolean isCodeidExists(String codeid);
}
