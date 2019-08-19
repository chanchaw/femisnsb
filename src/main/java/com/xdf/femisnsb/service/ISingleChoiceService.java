/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ISingleChoiceService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:51:53   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.SingleChoice;

/**   
 * @ClassName:  ISingleChoiceService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:51:54   
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
