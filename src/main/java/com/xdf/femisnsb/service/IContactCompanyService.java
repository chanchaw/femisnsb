/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  IContactCompanyService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��6�� ����3:57:03   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.ContactCompany;

/**
 * @author chanchaw
 *
 */
public interface IContactCompanyService {
	int insert(ContactCompany record);
	int deleteByPrimaryKey(String sid);
	int updateByPrimaryKey(ContactCompany record);
	int updateSelective(ContactCompany record);
	ContactCompany getByPrimaryKey(String sid);
	List<ContactCompany> getAll();
	List<ContactCompany> getAllValid();
	List<ContactCompany> getAllInvalid();
	List<ContactCompany> getChildren(Integer parentid);
}
