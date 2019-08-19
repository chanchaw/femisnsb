/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ISingleChoiceService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:51:53   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.SingleChoice;

/**   
 * @ClassName:  ISingleChoiceService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:51:54   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface ISingleChoiceService {

	void insert(SingleChoice record);
	void deleteByPrimaryKey(String sid);
	void updateByPrimaryKey(SingleChoice record);
	SingleChoice getByPrimaryKey(String sid);
	List<SingleChoice> getChildren(Integer pid);
	List<SingleChoice> getAll();
}
