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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午3:31:22   
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
     * 功能： 根据单据类型获取单据编号规则参数<br/>
     *  
     * @author chanchaw 
     * @param sid 
     *            单据类型，面料订单 = fabricOrder，不是完整的单据编号 for190801003
     * @return CfgBillCode 
     * @since 2019年8月2日 15:50:46
     */ 
	@Transactional(rollbackFor = Exception.class)
	public CfgBillCode getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}


    /** 
     * 功能： 传入单据类型，返回单据类型前缀，例如传入面料<br/>
     *            订单 fabricOrder返回：for190801，即自增数字前面部分
     *  
     * @author chanchaw 
     * @param sid 
     *            单据类型，例如面料订单 = fabricOrder 
     * @return String 
     * @since 2019年8月2日 15:50:46
     */  
	@Transactional(rollbackFor = Exception.class)
	public String getCurPrePart(String sid) {
		logger.info("传入参数sid=" + sid);
		CfgBillCode cfg = getByPrimaryKey(sid);
		if( cfg == null ) return "";
		
		String prePart = cfg.getPrefix().toString();
		
		String year = DateUtil.getYear8Length(cfg.getYear());
		String month = DateUtil.getMonth8Length(cfg.getMonth());
		String day = DateUtil.getDay8Length(cfg.getDay());
		
		logger.info("截取 meta 后，prePart = " + prePart + ",year = " + year + ",month = " + month + ",day = "+ day);
		
		StringBuilder sb = new StringBuilder();
		sb.append(prePart).append(year).append(month).append(day);
		logger.info("即将返回：" + sb.toString());
		return sb.toString();
	}

}
