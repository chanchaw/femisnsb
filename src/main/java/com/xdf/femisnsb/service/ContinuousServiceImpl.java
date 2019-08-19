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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午10:45:35   
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
     * 功能：从表 continuous 获取指定类型单据编号的记录<br/> 
     *  
     * @author chanchaw
     * @param sid 
     *            单据类型，例如面料订单 sid = fabricOrder
     * @return Continuous 模型的对象
     * @since 2019年8月1日 22:08:56 
     */
	@Transactional(rollbackFor = Exception.class)
	public Continuous getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}
	
	
	
    
	
	
	/**
	 * 依据单据编号缓存表Continuous获取最新的单据编号
	 * 1. 如果prePart不符合，则创建当前的prePart，自增数字为1
	 * 2. 如果prePart符合，则在当前自增数字的基础上累加1
	 * 返回下一个空白单据的编号
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
			if(lastCode.getPrepart().equals(prePart)) {// 前缀相同则计数器累加1
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
