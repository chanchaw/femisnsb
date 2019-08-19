/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  SingleChoiceServiceImpl.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:53:33   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
 */
package com.xdf.femisnsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.SingleChoiceMapper;
import com.xdf.femisnsb.model.SingleChoice;

/**   
 * @ClassName:  SingleChoiceServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:53:33   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class SingleChoiceServiceImpl implements ISingleChoiceService {
	@Autowired
	private SingleChoiceMapper dao;

	public void insert(SingleChoice record) {
		dao.insert(record);
	}

	public void deleteByPrimaryKey(String sid) {
		dao.deleteByPrimaryKey(sid);
	}


	public void updateByPrimaryKey(SingleChoice record) {
		dao.updateByPrimaryKey(record);
	}


	public SingleChoice getByPrimaryKey(String sid) {
		return dao.selectByPrimaryKey(sid);
	}

	public List<SingleChoice> getChildren(Integer pid) {
		return dao.selectChildren(pid);
	}

	@Override
	public List<SingleChoice> getAll() {
		return dao.selectAll();
	}

}
