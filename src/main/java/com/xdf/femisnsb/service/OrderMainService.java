package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.OrderMain;

/**   
 * @ClassName:  OrderMainService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午12:19:54   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface OrderMainService {
	int insert(OrderMain record);// 返回自增主键
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
    int save(OrderMain record);// 返回操作的主键
    
    boolean isCodeidExists(String codeid);
}
