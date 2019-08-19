package com.xdf.femisnsb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xdf.femisnsb.model.BillOrder;
import com.xdf.femisnsb.model.BillType;
import com.xdf.femisnsb.model.BillTypeEnum;
import com.xdf.femisnsb.model.OrderDetail;
import com.xdf.femisnsb.model.OrderMain;
import com.xdf.femisnsb.model.ResponseCode;
import com.xdf.femisnsb.model.ResponseResult;

/**   
 * @ClassName:  BillOrderServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2019年1月23日 下午12:23:28   
 *     
 * @Copyright: 2019 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class BillOrderServiceImpl implements BillOrderService {
	
	private static Logger logger = LoggerFactory.getLogger(ContinuousServiceImpl.class);
	
	@Autowired
	private OrderMainServiceImpl mService;
	
	@Autowired
	private OrderMainServiceAgg mServiceAgg;
	
	@Autowired
	private OrderDetailServiceImpl dService;
	
	@Autowired
	private ContinuousServiceAgg billCodeServiceAgg;
	
	@Autowired
	private ContinuousServiceImpl billCodeService;

	public boolean delete(Integer mainId) {
		dService.deleteByPrimaryKey(mainId);
		mService.deleteBPK(mainId);
		
		return true;
	}


	/**
	 * 如果没有第一单则返回NULL
	 */
	public ResponseResult moveFirst() {

		OrderMain main = mService.getFirst();
		if(main==null) return ResponseResult.failure( ResponseCode.NODATA );
		
		List<OrderDetail> details = dService.getByMainId(main.getId());
		
		BillOrder bill = new BillOrder();
		bill.setMain(main);
		bill.setDetails(details);
		return ResponseResult.success( bill );
	}


	/**
	 * 返回上单
	 * 1. 参照单不存在则退出
	 * 2. 上单不存在则查询获取下单
	 * 3. 下单不存在则返回NULL
	 */
	public ResponseResult movePrevious(Integer billId) {
		if(billId<=0) return ResponseResult.failure( ResponseCode.PARAM_ERROR );
		
		OrderMain main = mService.getPrevious(billId);
		if(main==null) return ResponseResult.success( "没有前一单了" );// 查询成功但是没有数据
		
		List<OrderDetail> details = dService.getByMainId(main.getId());
		if( details == null ) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		BillOrder bill = new BillOrder();
		bill.setMain( main );
		bill.setDetails( details );
		
		return ResponseResult.success( bill );
	}


	/**
	 * 返回下单
	 * 1. 参照单不存在则返回NULL
	 * 2. 下单不存在则返回上单
	 * 3. 上单不存在则返回NULL
	 */
	public ResponseResult moveNext(Integer billId) {
		if(billId<=0) return ResponseResult.failure( ResponseCode.PARAM_ERROR );
		
		OrderMain main = mService.getNext(billId);
		
		if(main==null) ResponseResult.success( "没有后一单了" );
		
		List<OrderDetail> details = dService.getByMainId(main.getId());
		if( details == null ) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		BillOrder bill = new BillOrder();
		bill.setMain(main);
		bill.setDetails(details);
		
		return ResponseResult.success( bill );
	}


	public ResponseResult moveLast() {
		OrderMain main = mService.getLast();
		
		if(main==null) return ResponseResult.failure( ResponseCode.NODATA );
		
		List<OrderDetail> details = dService.getByMainId(main.getId());
		if ( details == null ) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		BillOrder bill = new BillOrder();
		bill.setMain(main);
		bill.setDetails(details);
		return ResponseResult.success( bill );
	}


	/**
	 * 保存整个单据
	 * 1. 满足条件则返回false并且不进行保存：单据为空、主表为空、明细为空、明细没有数据
	 * 2. 保存主表，并且返回新增（或者修改）的主键值
	 * 3. 遍历明细数据设置字段 mainid
	 * 4. 批量保存明细数据（无则新增有则修改）
	 * 5. 返回带有自增主键数据的对象实例给前端
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public ResponseResult save(BillOrder record) {
		if(record == null) return  ResponseResult.failure( ResponseCode.PARAM_NULL );
		if(record.getMain() == null) return  ResponseResult.failure( ResponseCode.BILL_MAIN_NULL );
		if(record.getDetails() == null) return ResponseResult.failure( ResponseCode.BILL_DETAIL_NULL );
		if(record.getDetails().size()<=0) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		logger.info("保存前的单据对象是：" + record.toString());
		
		
		OrderMain main = record.getMain();
		String codeid = "";
		List<OrderDetail> details = record.getDetails();
		
		if( main.getCodeid().length() >0 ) {// 验证手动输入的单据 编号是否重复
			boolean ret = mService.isCodeidExists(main.getCodeid());
			if ( ret ) {// 手动录入的单据编号重复则返回 failure
				return ResponseResult.failure( ResponseCode.BILL_DUPLICATE_CODEID );
			}else {
				codeid = main.getCodeid();
			}
		}else {// 系统自动计算获得最新的单据编号
			codeid = billCodeService.getNewBillCode( BillTypeEnum.FABRIC_ORDER.getCode());
		}
		
		main.setCodeid(codeid);
		
		// 保存主表数据
		Integer id = mServiceAgg.save(main);

		for (OrderDetail orderDetail : details) {
			orderDetail.setMainid(id);
		}
		
//		int a = 1/0;

		// 保存明细数据 - list
		dService.saveList(details);
		
		logger.info("保存后的单据对象是：" + record.toString());
		
		// 更新单据编号注册表
		BillType obj = new BillType("fabricOrder",main.getCodeid());
		billCodeServiceAgg.updateBillCode(obj);
		
		logger.info("更新到单据缓存表的对象是：" + obj.toString());
		return ResponseResult.success( record );
	}


	public BillOrder getByPrimaryKey(Integer mainId) {
		BillOrder bill = new BillOrder();
		bill.setMain(mService.getByPrimaryKey(mainId));		
		bill.setDetails(dService.getByMainId(mainId));
		
		return bill;
	}


	public boolean isCodeidExist(String codeid) {
		OrderMain orderMain = mService.getByCodeid(codeid);
		
		if(orderMain!=null) 
			return true;
		else
			return false;
	}


	@Override
	public int saveBatch(List<OrderDetail> list) {
//		return daoDetail.saveBatch(list);
		return 0;
	}
	
	

}
