/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  SingleChoiceCategoryServiceImpl.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:15:06   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * ע�⣺�������¶������ܻ�ϵͳ�������޹�˾
 */
package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdf.femisnsb.dao.SingleChoiceCategoryMapper;
import com.xdf.femisnsb.model.SingleChoiceCategory;
import com.xdf.femisnsb.model.NzTreeNode;

/**   
 * @ClassName:  SingleChoiceCategoryServiceImpl   
 * @Description:TODO(������һ�仰��������������)   
 * @author: chanchaw
 * @date:   2018��12��20�� ����11:15:06   
 *     
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 */
@Service
public class SingleChoiceCategoryServiceImpl implements ISingleChoiceCategoryService {
	@Autowired
	private SingleChoiceCategoryMapper dao;
	
	private static Logger logger = LoggerFactory.getLogger(ContactCategoryServiceImpl.class);

	public void insert(SingleChoiceCategory record) {
		dao.insert(record);
	}

	public void deleteByPrimaryKey(Integer id) {
		dao.deleteByPrimaryKey(id);
	}


	public void updateByPrimaryKey(SingleChoiceCategory record) {
		dao.updateByPrimaryKey(record);
	}


	public SingleChoiceCategory getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<SingleChoiceCategory> getAll() {
		return dao.selectAll();
	}
	
	/*
	 * 	������4�����������ʵ�ֽ�DB�������ݼ���ת��Ϊӵ�и��ӹ�ϵ�����νṹ������
	 * 	�ⲿ���ã�
	 * 		ֻҪ���÷���buildTree()����Ϊ��ȡ���е��������ݲ���ת��Ϊ���νṹ
	 * 	��ֲʹ�ã�
	 * 		1. �޸ı��Ӧ��ģ������ - SingleChoiceCategory
	 * 		2. �޸�getId��getTitle��getParentid�������ƣ���֤����
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<SingleChoiceCategory> list = this.getAll();
		logger.info(list.toString());
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<SingleChoiceCategory> tableData) {
    	Integer root = 1;// ���ڵ��ֵ
    	
        List<NzTreeNode> nodeList = tableData2NodeList(tableData);
        logger.info("ģ�ͼ���ת��Ϊ�ڵ㼯���ǣ�");
        logger.info(nodeList.toString());
        
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
    public List<NzTreeNode> tableData2NodeList(List<SingleChoiceCategory> tableData){
    	List<NzTreeNode> nodeList = new ArrayList<NzTreeNode>();
    	for (SingleChoiceCategory ele : tableData) {
			NzTreeNode node = new NzTreeNode();
			node.setKey(ele.getId());
			node.setTitle(ele.getName());
			node.setParentId(ele.getPid());
			
			nodeList.add(node);
		}
    	logger.info(nodeList.toString());
    	return nodeList;
    }
    // ================================��ȡ���νṹ�������========================================
    

}
