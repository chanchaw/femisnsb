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
     * 功能：在保存一个单据后调用本方法更新单据编号缓存表<br/> 
     * 1. 表Continuous中不存在指定值的 sid行，则插入新的行，自增数字从1开始<br/>
     * 2. 表Continuous中 sid上存在指定的值，但是prepart需要更新，同时increament=1<br/>
     * 3. 表Continuous中的prePart和当前的相同，则只要更新increament = increament +1即可<br/>
     * 
     * @author chanchaw
     * @param billSid 
     *            详细到日期的单据编号，不需要自增数字，例如单据编号 for190427001，只要传入 for190427 即可
     * @return String 返回完整的单据编号 - 带有前后缀
     * @since 2019年8月1日 22:13:06 
     */
	@Transactional(rollbackFor = Exception.class)
	public String updateBillCode(BillType billType) {
		logger.info(billType.toString());
		
		CfgBillCode cfg = cfgService.getByPrimaryKey(billType.getBillType());
		String prePart = cfgService.getCurPrePart(billType.getBillType());
		String suffix = cfg.getSuffix();
		suffix = StringUtil.toString(suffix);

			
		Continuous dbRecord = service.getByPrimaryKey(billType.getBillType());
		if(dbRecord==null) {// 该单据类型没有缓存记录则写入第一笔
			dbRecord = new Continuous();
			dbRecord.setIncreament(1);
			dbRecord.setPrepart(prePart);
			dbRecord.setSid(billType.getBillType());
			dbRecord.setSuffix(suffix);
			
			service.insert(dbRecord);
		}else {// 存在则修改
			if(dbRecord.getPrepart().equals(prePart)) {// 前缀相同，计数器累加1
				dbRecord.setIncreament(dbRecord.getIncreament() + 1);
			}else {
				dbRecord.setIncreament(1);
			}
			
			dbRecord.setPrepart(prePart);
			
			// 前缀不同，计数器重置为1 - 采用record
			service.updateByPrimaryKey(dbRecord);
		}
		
		logger.info("逻辑执行完毕，即将返回结果");
		return dbRecord.getPrepart() + StringUtil.leftPad(dbRecord.getIncreament().toString(), cfg.getIncrease(), "0") 
			+ StringUtil.toString(dbRecord.getSuffix());
	}
}
