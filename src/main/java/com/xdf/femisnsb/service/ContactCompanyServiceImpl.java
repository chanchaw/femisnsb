/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ContactCompanyServiceImpl.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��6�� ����3:59:19   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.ContactCompanyMapper;
import com.xdf.femisnsb.model.ContactCompany;

/**
 * @author chanchaw
 *
 */

@Service
public class ContactCompanyServiceImpl implements IContactCompanyService {
	private static Logger logger = LoggerFactory.getLogger(ContactCompanyServiceImpl.class);
	
	@Autowired
	private ContactCompanyMapper dao;

	public int insert(ContactCompany record) {
		Integer rtn = dao.insert(record);
		
		return rtn;
	}


	public int deleteByPrimaryKey(String sid) {
		return dao.deleteByPrimaryKey(sid);
	}

	public int updateByPrimaryKey(ContactCompany record) {
		return dao.updateByPrimaryKey(record);
	}

	public ContactCompany getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}

	public List<ContactCompany> getAll() {
		List<ContactCompany> list = dao.selectAll();
		logger.info(list.toString());
		return list;
	}

	public List<ContactCompany> getAllValid() {
		return dao.selectAllValid();
	}

	public List<ContactCompany> getAllInvalid() {
		return dao.selectAllInvalid();
	}

	public List<ContactCompany> getChildren(Integer parentid) {
		return dao.selectChildren(parentid);
	}


	@Override
	public int updateSelective(ContactCompany record) {
		return dao.updateSelective(record);
	}

}
