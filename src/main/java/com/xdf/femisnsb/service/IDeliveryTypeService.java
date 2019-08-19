/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  IDeliveryTypeService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午10:31:26   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.DeliveryType;

/**   
 * @ClassName:  IDeliveryTypeService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午10:31:26   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface IDeliveryTypeService {
	void insert(DeliveryType record);
	void deleteByPrimaryKey(String sid);
	void updateByPrimaryKey(DeliveryType record);
	DeliveryType getByPrimaryKey(String sid);
	List<DeliveryType> getAll();
}
