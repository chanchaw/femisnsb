package com.xdf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ConcurrencyThrottleSupport;

import com.xdf.femisnsb.model.CfgBillCode;
import com.xdf.femisnsb.model.Continuous;
import com.xdf.femisnsb.service.CfgBillCodeServiceImpl;
import com.xdf.femisnsb.service.ContinuousServiceImpl;

/**   
 * @ClassName:  BillCodeUtils   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月30日 下午10:54:15   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Component
public class BillCodeUtils {

	@Autowired
	private CfgBillCodeServiceImpl cfgService;
	
	@Autowired
	private ContinuousServiceImpl conuService;
//	private CfgBillCodeServiceImpl cfgService = new CfgBillCodeServiceImpl();
//	private ContinuousServiceImpl conuService = new ContinuousServiceImpl();
//	
	
	/**
	 * 获取单据编号自增数字之前的部分
	 * sid：配置表中的主键 = CfgBillCode.sid
	 */
	public String getPrePart(String sid) {
		CfgBillCode cfg = this.cfgService.getByPrimaryKey(sid);
		if(cfg==null) return "";
		
		StringBuilder codeId=new StringBuilder(cfg.getPrefix());
		codeId.append(DateUtil.getYear8Length(cfg.getYear()));
		codeId.append(DateUtil.getMonth8Length(cfg.getMonth()));
		codeId.append(DateUtil.getDay8Length(cfg.getDay()));
		
		Integer seq = 1;
		Continuous cons = conuService.getPrepartLast(codeId.toString());
		if(cons != null) {
			seq = cons.getIncreament() + 1;
		}
		
		String  rtn= codeId.append(StringUtil.leftPad(seq.toString(), cfg.getIncrease(), "0")).toString();
		return rtn;
	}
	
	
	/**
	 * 在保存一个单据后调用本方法更新单据编号缓存表
	 * 1. 表Continuous中不存在指定值的 sid行，则插入新的行
	 * 2. 表Continuous中 sid上存在指定的值，但是prepart需要更新，同时increament=1
	 * 3. 表Continuous中的prePart和当前的相同，则只要更新increament = increament +1即可 
	 * 返回当前最后一个单据编号（前后缀构建起来）
	 */
	public void updateBillCode(String billSid) {
		String prePart = cfgService.getCurPrePart(billSid);
		String suffix = new CfgBillCode().getSuffix();
		
		Continuous record = new Continuous();
		record.setIncreament(1);
		record.setPrepart(prePart);
		record.setSid(billSid);
		record.setSuffix(suffix);
		
		Continuous dbRecord = conuService.getByPrimaryKey(billSid);
		if(dbRecord==null) {// 不存在则查询新行
			conuService.insert(record);
		}else {// 存在则修改
			if(record.getPrepart().equals(dbRecord.getPrepart())) {// 前缀相同，计数器累加1
				record.setIncreament(dbRecord.getIncreament() + 1);
			}
			
			// 前缀不同，计数器重置为1 - 采用record
			conuService.updateByPrimaryKey(record);
		}
		
	}
	
	
	/**
	 * 依据单据编号缓存表Continuous获取最新的单据编号
	public String getNewBillCode(String billSid) {
		Continuous continuous = conuService.getByPrimaryKey(billSid);
		String prePart = cfgService.getCurPrePart(billSid);
		CfgBillCode cfg = new CfgBillCode(); 
		Integer count = cfg.getIncrease();
		Integer increase = 1;
		String suffix = cfg.getSuffix();
		
		if(continuous.getPrepart().equals(prePart)) {// 前缀相同则计数器累加1
			increase = continuous.getIncreament() + 1;
		}
		
		String szIncr = StringUtil.leftPad(increase.toString(), count, "0");
		
				
		return prePart + szIncr + suffix;
	}
	*/
	
}
