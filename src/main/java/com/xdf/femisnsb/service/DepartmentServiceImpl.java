package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.DepartmentMapper;
import com.xdf.femisnsb.model.Department;
import com.xdf.femisnsb.model.NzTreeNode;

/**   
 * @ClassName:  DepartmentServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月27日 下午6:45:43   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentMapper dao;
	
	public void insert(Department record) {
		dao.insert(record);
	}

	public void deleteByPrimaryKey(Integer id) {
		dao.deleteByPrimaryKey(id);
	}

	public void updateByPrimaryKey(Department record) {
		dao.updateByPrimaryKey(record);
	}

	public Department getByPrimary(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Department> getAll() {
		return dao.selectAll();
	}
	
	
	/*
	 * 	下面是4个方法组合是实现将DB表中数据集合转换为拥有父子关系的树形结构的数据
	 * 	外部调用：
	 * 		只要调用方法buildTree()，即为获取表中的所有数据并且转换为树形结构
	 * 	移植使用：
	 * 		1. 修改表对应的模型类型 - Department
	 * 		2. 修改getId、getTitle、getParentid方法名称，保证可用
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<Department> list = this.getAll();
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<Department> tableData) {
    	Integer root = 0;// 根节点的值
    	
        List<NzTreeNode> nodeList = tableData2NodeList(tableData);
        List<NzTreeNode> tree = new ArrayList<NzTreeNode>();
        for (NzTreeNode treeNode : nodeList) {
            if (treeNode.getParentId() == root) {
                tree.add(getChildren(treeNode,nodeList));
            }
        }
        logger.info(tree.toString());
        return tree;
    }
 
    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    public NzTreeNode getChildren(NzTreeNode treeNode,List<NzTreeNode> treeNodes) {
        for (NzTreeNode it : treeNodes) {
            if(treeNode.getKey().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<NzTreeNode>());
                }
                treeNode.getChildren().add(getChildren(it,treeNodes));
            }
        }
        return treeNode;
    }
    
    
    /*
     * 从表finishedproductcategory获取的数据转换为树形节点的list
     */
    public List<NzTreeNode> tableData2NodeList(List<Department> tableData){
    	List<NzTreeNode> nodeList = new ArrayList<NzTreeNode>();
    	for (Department ele : tableData) {
			NzTreeNode node = new NzTreeNode();
			node.setKey(ele.getId());
			node.setTitle(ele.getName());
			node.setParentId(ele.getPid());
			
			nodeList.add(node);
		}
    	return nodeList;
    }
    // ================================获取树形结构数据完毕========================================

}
