package com.xdf.femisnsb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.model.BillType;
import com.xdf.femisnsb.model.CfgBillCode;
import com.xdf.femisnsb.model.Continuous;
import com.xdf.utils.StringUtil;

@Service
public class ContinuousServiceAgg {
	private static Logger logger = LoggerFactory.getLogger(CfgBillCodeServiceImpl.class);
	
	@Autowired
	private CfgBillCodeServiceImpl cfgService;
	
	@Autowired
	private ContinuousServiceImpl service;

	/** 
     * ���ܣ��ڱ���һ�����ݺ���ñ��������µ��ݱ�Ż����<br/> 
     * 1. ��Continuous�в�����ָ��ֵ�� sid�У�������µ��У��������ִ�1��ʼ<br/>
     * 2. ��Continuous�� sid�ϴ���ָ����ֵ������prepart��Ҫ���£�ͬʱincreament=1<br/>
     * 3. ��Continuous�е�prePart�͵�ǰ����ͬ����ֻҪ����increament = increament +1����<br/>
     * 
     * @author chanchaw
     * @param billSid 
     *            ��ϸ�����ڵĵ��ݱ�ţ�����Ҫ�������֣����絥�ݱ�� for190427001��ֻҪ���� for190427 ����
     * @return String ���������ĵ��ݱ�� - ����ǰ��׺
     * @since 2019��8��1�� 22:13:06 
     */
	@Transactional(rollbackFor = Exception.class)
	public String updateBillCode(BillType billType) {
		logger.info(billType.toString());
		
		CfgBillCode cfg = cfgService.getByPrimaryKey(billType.getBillType());
		String prePart = cfgService.getCurPrePart(billType.getBillType());
		String suffix = cfg.getSuffix();
		suffix = StringUtil.toString(suffix);

			
		Continuous dbRecord = service.getByPrimaryKey(billType.getBillType());
		if(dbRecord==null) {// �õ�������û�л����¼��д���һ��
			dbRecord = new Continuous();
			dbRecord.setIncreament(1);
			dbRecord.setPrepart(prePart);
			dbRecord.setSid(billType.getBillType());
			dbRecord.setSuffix(suffix);
			
			service.insert(dbRecord);
		}else {// �������޸�
			if(dbRecord.getPrepart().equals(prePart)) {// ǰ׺��ͬ���������ۼ�1
				dbRecord.setIncreament(dbRecord.getIncreament() + 1);
			}else {
				dbRecord.setIncreament(1);
			}
			
			dbRecord.setPrepart(prePart);
			
			// ǰ׺��ͬ������������Ϊ1 - ����record
			service.updateByPrimaryKey(dbRecord);
		}
		
		logger.info("�߼�ִ����ϣ��������ؽ��");
		return dbRecord.getPrepart() + StringUtil.leftPad(dbRecord.getIncreament().toString(), cfg.getIncrease(), "0") 
			+ StringUtil.toString(dbRecord.getSuffix());
	}
}
