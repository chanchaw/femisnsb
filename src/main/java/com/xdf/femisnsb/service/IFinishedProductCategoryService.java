package com.xdf.femisnsb.service;

import java.util.List;

import com.xdf.femisnsb.model.FinishedProductCategory;
import com.xdf.femisnsb.model.NzTreeNode;

public interface IFinishedProductCategoryService {
	int insert(FinishedProductCategory instance);
	int deleteByPrimaryKey(Integer id);
	Integer updateByPrimaryKey(FinishedProductCategory instance);
	
	FinishedProductCategory getByPrimaryKey(Integer id);
	List<FinishedProductCategory> getAll();
	List<FinishedProductCategory> getAllValid();
	List<FinishedProductCategory> getAllInvalid();
	
	boolean isExist(Integer id);
	boolean isExist(String name);
	List<NzTreeNode> buildTree();
	List<NzTreeNode> buildTreeByList(List<FinishedProductCategory> tableData);
	NzTreeNode getChildren(NzTreeNode treeNode,List<NzTreeNode> tree);
	List<NzTreeNode> tableData2NodeList(List<FinishedProductCategory> tableData);
}
