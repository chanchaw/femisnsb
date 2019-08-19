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
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��30�� ����10:54:15   
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
	 * ��ȡ���ݱ����������֮ǰ�Ĳ���
	 * sid�����ñ��е����� = CfgBillCode.sid
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
	 * �ڱ���һ�����ݺ���ñ��������µ��ݱ�Ż����
	 * 1. ��Continuous�в�����ָ��ֵ�� sid�У�������µ���
	 * 2. ��Continuous�� sid�ϴ���ָ����ֵ������prepart��Ҫ���£�ͬʱincreament=1
	 * 3. ��Continuous�е�prePart�͵�ǰ����ͬ����ֻҪ����increament = increament +1���� 
	 * ���ص�ǰ���һ�����ݱ�ţ�ǰ��׺����������
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
		if(dbRecord==null) {// ���������ѯ����
			conuService.insert(record);
		}else {// �������޸�
			if(record.getPrepart().equals(dbRecord.getPrepart())) {// ǰ׺��ͬ���������ۼ�1
				record.setIncreament(dbRecord.getIncreament() + 1);
			}
			
			// ǰ׺��ͬ������������Ϊ1 - ����record
			conuService.updateByPrimaryKey(record);
		}
		
	}
	
	
	/**
	 * ���ݵ��ݱ�Ż����Continuous��ȡ���µĵ��ݱ��
	public String getNewBillCode(String billSid) {
		Continuous continuous = conuService.getByPrimaryKey(billSid);
		String prePart = cfgService.getCurPrePart(billSid);
		CfgBillCode cfg = new CfgBillCode(); 
		Integer count = cfg.getIncrease();
		Integer increase = 1;
		String suffix = cfg.getSuffix();
		
		if(continuous.getPrepart().equals(prePart)) {// ǰ׺��ͬ��������ۼ�1
			increase = continuous.getIncreament() + 1;
		}
		
		String szIncr = StringUtil.leftPad(increase.toString(), count, "0");
		
				
		return prePart + szIncr + suffix;
	}
	*/
	
}
