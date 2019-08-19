/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  IDeliveryTypeService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:31:26   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.DeliveryType;

/**   
 * @ClassName:  IDeliveryTypeService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:31:26   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface IDeliveryTypeService {
	void insert(DeliveryType record);
	void deleteByPrimaryKey(String sid);
	void updateByPrimaryKey(DeliveryType record);
	DeliveryType getByPrimaryKey(String sid);
	List<DeliveryType> getAll();
}
