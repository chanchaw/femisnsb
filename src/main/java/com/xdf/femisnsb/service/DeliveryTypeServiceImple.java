/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  DeliveryTypeServiceImple.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:38:20   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.DeliveryTypeMapper;
import com.xdf.femisnsb.model.DeliveryType;

/**   
 * @ClassName:  DeliveryTypeServiceImple   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����10:38:20   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class DeliveryTypeServiceImple implements IDeliveryTypeService {

	@Autowired
	private DeliveryTypeMapper dao;
	
	public void insert(DeliveryType record) {
		dao.insert(record);
	}

	
	public void deleteByPrimaryKey(String sid) {
		dao.deleteByPrimaryKey(sid);
	}

	public void updateByPrimaryKey(DeliveryType record) {
		dao.updateByPrimaryKey(record);
	}

	public DeliveryType getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}

	public List<DeliveryType> getAll() {
		return dao.selectAll();
	}

}
