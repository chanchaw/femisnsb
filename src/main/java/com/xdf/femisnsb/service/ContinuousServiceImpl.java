package com.xdf.femisnsb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.dao.ContinuousMapper;
import com.xdf.femisnsb.model.CfgBillCode;
import com.xdf.femisnsb.model.Continuous;
import com.xdf.femisnsb.model.OrderMain;
import com.xdf.utils.StringUtil;

/**   
 * @ClassName:  ContinuousServiceImpl   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����10:45:35   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class ContinuousServiceImpl implements ContinuousService {

	private static Logger logger = LoggerFactory.getLogger(ContinuousServiceImpl.class);
	
	@Autowired
	private ContinuousMapper dao;
	
	@Autowired
	private CfgBillCodeServiceImpl cfgService;
//	private CfgBillCodeServiceImpl cfgService = new CfgBillCodeServiceImpl();
	
	@Transactional(rollbackFor = Exception.class)
	public int insert(Continuous record) {
//		Continuous recordDB = getByPrimaryKey(record.getSid());
//		if(recordDB == null) {
//			return dao.insert(record);
//		}
		
		return dao.insert(record);
	}

	public int deleteByPrimaryKey(String sid) {
		return dao.deleteByPrimaryKey(sid);
	}


	@Transactional(rollbackFor = Exception.class)
	public int updateByPrimaryKey(Continuous record) {
		return dao.updateByPrimaryKey(record);
	}

    /** 
     * ���ܣ��ӱ� continuous ��ȡָ�����͵��ݱ�ŵļ�¼<br/> 
     *  
     * @author chanchaw
     * @param sid 
     *            �������ͣ��������϶��� sid = fabricOrder
     * @return Continuous ģ�͵Ķ���
     * @since 2019��8��1�� 22:08:56 
     */
	@Transactional(rollbackFor = Exception.class)
	public Continuous getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}
	
	
	
    
	
	
	/**
	 * ���ݵ��ݱ�Ż����Continuous��ȡ���µĵ��ݱ��
	 * 1. ���prePart�����ϣ��򴴽���ǰ��prePart����������Ϊ1
	 * 2. ���prePart���ϣ����ڵ�ǰ�������ֵĻ������ۼ�1
	 * ������һ���հ׵��ݵı��
	 */
	public String getNewBillCode(String billSid) {
		Continuous lastCode = getByPrimaryKey(billSid);
		
		String prePart = cfgService.getCurPrePart(billSid);
		
		CfgBillCode cfg = cfgService.getByPrimaryKey(billSid); 
		Integer count = cfg.getIncrease();
		Integer increase = 1;
		
		
		String suffix = cfg.getSuffix();
		suffix=StringUtil.toString(suffix);
		
		if(lastCode!=null) {
			if(lastCode.getPrepart().equals(prePart)) {// ǰ׺��ͬ��������ۼ�1
				increase = lastCode.getIncreament() + 1;
			}
		}
		
		String szIncr = StringUtil.leftPad(increase.toString(), count, "0");
		
		StringBuilder sb = new StringBuilder();
		sb.append(prePart).append(szIncr).append(suffix);
		return sb.toString();
	}

	public Continuous getPrepartLast(String prePart) {
		return dao.selectPrepartLast(prePart);
	}

	@Override
	public boolean isFabricBillcodeExists(String codeid) {
		OrderMain obj = dao.isFabricBillcodeExists(codeid);
		System.out.println(obj);
		if (obj == null) 
			return false;
		else 
			return true;
	}
	

	public static void main(String[] args) {

	}

}
