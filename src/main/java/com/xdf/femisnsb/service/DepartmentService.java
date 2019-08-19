package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.Department;
import com.xdf.femisnsb.model.NzTreeNode;

/**   
 * @ClassName:  DepartmentService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午6:43:37   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
public interface DepartmentService {
	void insert(Department record);
	void deleteByPrimaryKey(Integer id);
	void updateByPrimaryKey(Department record);
	Department getByPrimary(Integer id);
	List<Department> getAll();
	List<NzTreeNode> buildTree();
}
