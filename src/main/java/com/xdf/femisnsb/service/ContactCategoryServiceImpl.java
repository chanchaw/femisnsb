package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdf.femisnsb.dao.ContactCategoryMapper;
import com.xdf.femisnsb.model.ContactCategory;
import com.xdf.femisnsb.model.NzTreeNode;


@Service
public class ContactCategoryServiceImpl implements IContactCategoryService {
	private static Logger logger = LoggerFactory.getLogger(ContactCategoryServiceImpl.class);

	@Autowired
	private ContactCategoryMapper dao;
	
	public int insert(ContactCategory record) {
		return dao.insert(record);
	}

	public int deleteByPrimary(String sid) {
		return dao.deleteByPrimaryKey(sid);
	}

	public int updateByPrimary(ContactCategory record) {
		return dao.updateByPrimaryKey(record);
	}

	public ContactCategory getByPrimary(String sid) {
		return dao.selectByPrimaryKey(sid);
	}

	public List<ContactCategory> getAll() {
		return dao.selectAll();
	}
	
	
	/*
	 * 	������4�����������ʵ�ֽ�DB�������ݼ���ת��Ϊӵ�и��ӹ�ϵ�����νṹ������
	 * 	�ⲿ���ã�
	 * 		ֻҪ���÷���buildTree()����Ϊ��ȡ���е��������ݲ���ת��Ϊ���νṹ
	 * 	��ֲʹ�ã�
	 * 		1. �޸ı��Ӧ��ģ������ - ContactCategory
	 * 		2. �޸�getId��getTitle��getParentid�������ƣ���֤����
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<ContactCategory> list = this.getAll();
		logger.info(list.toString());
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<ContactCategory> tableData) {
    	Integer root = 0;// ���ڵ��ֵ
    	
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
    public List<NzTreeNode> tableData2NodeList(List<ContactCategory> tableData){
//    	List<NzTreeNode> nodeList = new ArrayList<NzTreeNode>();
//    	for (ContactCategory ele : tableData) {
//			NzTreeNode node = new NzTreeNode();
//			node.setKey(ele.getId());
//			node.setTitle(ele.getName());
//			node.setParentId(ele.getPid());
//			
//			nodeList.add(node);
//		}
//    	logger.info(nodeList.toString());
//    	return nodeList;
    	return null;
    }
    // ================================��ȡ���νṹ�������========================================

	/* (non-Javadoc)
	 * @see com.xdf.femisnsb.service.IContactCategoryService#getByName(java.lang.String)
	 */
	public ContactCategory getByName(String name) {
		return dao.selectByName(name);
	}

	/* (non-Javadoc)
	 * @see com.xdf.femisnsb.service.IContactCategoryService#getByTitle(java.lang.String)
	 */
	public ContactCategory getByTitle(String title) {
		return dao.selectByTitle(title);
	}
    
	public List<ContactCategory> getAllValid(){
		return dao.selectAllValid();
	}

	@Override
	public String getCategoryNames(String categories) {
		return dao.getCategoryNames(categories);
	}
}
