package com.xdf.femisnsb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.dao.CfgBillCodeMapper;
import com.xdf.femisnsb.model.CfgBillCode;
import com.xdf.utils.DateUtil;

/**   
 * @ClassName:  CfgBillCodeServiceImpl   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����3:31:22   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class CfgBillCodeServiceImpl implements CfgBillCodeService {

	private static Logger logger = LoggerFactory.getLogger(CfgBillCodeServiceImpl.class);
	
	@Autowired
	private CfgBillCodeMapper dao;
	
	public int insert(CfgBillCode record) {
		return dao.insert(record);
	}

	
	public int deleteByPrimaryKey(String sid) {
		return dao.deleteByPrimaryKey(sid);
	}

	public int updateByPrimaryKey(CfgBillCode record) {
		return dao.updateByPrimaryKey(record);
	}

    /** 
     * ���ܣ� ���ݵ������ͻ�ȡ���ݱ�Ź������<br/>
     *  
     * @author chanchaw 
     * @param sid 
     *            �������ͣ����϶��� = fabricOrder�����������ĵ��ݱ�� for190801003
     * @return CfgBillCode 
     * @since 2019��8��2�� 15:50:46
     */ 
	@Transactional(rollbackFor = Exception.class)
	public CfgBillCode getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}


    /** 
     * ���ܣ� ���뵥�����ͣ����ص�������ǰ׺�����紫������<br/>
     *            ���� fabricOrder���أ�for190801������������ǰ�沿��
     *  
     * @author chanchaw 
     * @param sid 
     *            �������ͣ��������϶��� = fabricOrder 
     * @return String 
     * @since 2019��8��2�� 15:50:46
     */  
	@Transactional(rollbackFor = Exception.class)
	public String getCurPrePart(String sid) {
		logger.info("�������sid=" + sid);
		CfgBillCode cfg = getByPrimaryKey(sid);
		if( cfg == null ) return "";
		
		String prePart = cfg.getPrefix().toString();
		
		String year = DateUtil.getYear8Length(cfg.getYear());
		String month = DateUtil.getMonth8Length(cfg.getMonth());
		String day = DateUtil.getDay8Length(cfg.getDay());
		
		logger.info("��ȡ meta ��prePart = " + prePart + ",year = " + year + ",month = " + month + ",day = "+ day);
		
		StringBuilder sb = new StringBuilder();
		sb.append(prePart).append(year).append(month).append(day);
		logger.info("�������أ�" + sb.toString());
		return sb.toString();
	}

}
