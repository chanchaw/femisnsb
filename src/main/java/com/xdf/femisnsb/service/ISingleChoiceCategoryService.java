/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  ISingleChoiceCategoryService.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:13:35   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.SingleChoiceCategory;

/**   
 * @ClassName:  ISingleChoiceCategoryService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:13:35   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface ISingleChoiceCategoryService {

	void insert(SingleChoiceCategory record);
	void deleteByPrimaryKey(Integer id);
	void updateByPrimaryKey(SingleChoiceCategory record);
	SingleChoiceCategory getByPrimaryKey(Integer id);
	List<SingleChoiceCategory> getAll();
}
