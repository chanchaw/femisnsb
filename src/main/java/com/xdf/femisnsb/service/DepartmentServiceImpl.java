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
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��27�� ����6:45:43   
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
	 * 	������4�����������ʵ�ֽ�DB�������ݼ���ת��Ϊӵ�и��ӹ�ϵ�����νṹ������
	 * 	�ⲿ���ã�
	 * 		ֻҪ���÷���buildTree()����Ϊ��ȡ���е��������ݲ���ת��Ϊ���νṹ
	 * 	��ֲʹ�ã�
	 * 		1. �޸ı��Ӧ��ģ������ - Department
	 * 		2. �޸�getId��getTitle��getParentid�������ƣ���֤����
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<Department> list = this.getAll();
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<Department> tableData) {
    	Integer root = 0;// ���ڵ��ֵ
    	
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
     * �ݹ�����ӽڵ�
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
     * �ӱ�finishedproductcategory��ȡ������ת��Ϊ���νڵ��list
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
    // ================================��ȡ���νṹ�������========================================

}
