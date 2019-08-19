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
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2019��1��23�� ����12:23:28   
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
	 * ���û�е�һ���򷵻�NULL
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
	 * �����ϵ�
	 * 1. ���յ����������˳�
	 * 2. �ϵ����������ѯ��ȡ�µ�
	 * 3. �µ��������򷵻�NULL
	 */
	public ResponseResult movePrevious(Integer billId) {
		if(billId<=0) return ResponseResult.failure( ResponseCode.PARAM_ERROR );
		
		OrderMain main = mService.getPrevious(billId);
		if(main==null) return ResponseResult.success( "û��ǰһ����" );// ��ѯ�ɹ�����û������
		
		List<OrderDetail> details = dService.getByMainId(main.getId());
		if( details == null ) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		BillOrder bill = new BillOrder();
		bill.setMain( main );
		bill.setDetails( details );
		
		return ResponseResult.success( bill );
	}


	/**
	 * �����µ�
	 * 1. ���յ��������򷵻�NULL
	 * 2. �µ��������򷵻��ϵ�
	 * 3. �ϵ��������򷵻�NULL
	 */
	public ResponseResult moveNext(Integer billId) {
		if(billId<=0) return ResponseResult.failure( ResponseCode.PARAM_ERROR );
		
		OrderMain main = mService.getNext(billId);
		
		if(main==null) ResponseResult.success( "û�к�һ����" );
		
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
	 * ������������
	 * 1. ���������򷵻�false���Ҳ����б��棺����Ϊ�ա�����Ϊ�ա���ϸΪ�ա���ϸû������
	 * 2. �����������ҷ��������������޸ģ�������ֵ
	 * 3. ������ϸ���������ֶ� mainid
	 * 4. ����������ϸ���ݣ��������������޸ģ�
	 * 5. ���ش��������������ݵĶ���ʵ����ǰ��
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public ResponseResult save(BillOrder record) {
		if(record == null) return  ResponseResult.failure( ResponseCode.PARAM_NULL );
		if(record.getMain() == null) return  ResponseResult.failure( ResponseCode.BILL_MAIN_NULL );
		if(record.getDetails() == null) return ResponseResult.failure( ResponseCode.BILL_DETAIL_NULL );
		if(record.getDetails().size()<=0) return ResponseResult.failure( ResponseCode.BILL_DETAIL_EMPTY );
		
		logger.info("����ǰ�ĵ��ݶ����ǣ�" + record.toString());
		
		
		OrderMain main = record.getMain();
		String codeid = "";
		List<OrderDetail> details = record.getDetails();
		
		if( main.getCodeid().length() >0 ) {// ��֤�ֶ�����ĵ��� ����Ƿ��ظ�
			boolean ret = mService.isCodeidExists(main.getCodeid());
			if ( ret ) {// �ֶ�¼��ĵ��ݱ���ظ��򷵻� failure
				return ResponseResult.failure( ResponseCode.BILL_DUPLICATE_CODEID );
			}else {
				codeid = main.getCodeid();
			}
		}else {// ϵͳ�Զ����������µĵ��ݱ��
			codeid = billCodeService.getNewBillCode( BillTypeEnum.FABRIC_ORDER.getCode());
		}
		
		main.setCodeid(codeid);
		
		// ������������
		Integer id = mServiceAgg.save(main);

		for (OrderDetail orderDetail : details) {
			orderDetail.setMainid(id);
		}
		
//		int a = 1/0;

		// ������ϸ���� - list
		dService.saveList(details);
		
		logger.info("�����ĵ��ݶ����ǣ�" + record.toString());
		
		// ���µ��ݱ��ע���
		BillType obj = new BillType("fabricOrder",main.getCodeid());
		billCodeServiceAgg.updateBillCode(obj);
		
		logger.info("���µ����ݻ����Ķ����ǣ�" + obj.toString());
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
