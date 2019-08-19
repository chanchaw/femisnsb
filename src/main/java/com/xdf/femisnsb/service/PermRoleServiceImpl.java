package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdf.femisnsb.dao.PermRoleMapper;
import com.xdf.femisnsb.model.PermRole;
import com.xdf.femisnsb.model.NzTreeNode;


@Service
public class PermRoleServiceImpl implements IPermRoleService {

	private static Logger logger = LoggerFactory.getLogger(PermRoleServiceImpl.class);
	
	@Autowired
	private PermRoleMapper dao;
	
	public int insert(PermRole instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKey(PermRole instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public PermRole getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<PermRole> getAll() {
		return dao.selectAll();
	}

	public List<PermRole> getAllValid() {
		return dao.selectAllValid();
	}

	public List<PermRole> getAllInvalid() {
		return dao.selectAllInvalid();
	}
	
	
	
	/*
	 * 	������4�����������ʵ�ֽ�DB�������ݼ���ת��Ϊӵ�и��ӹ�ϵ�����νṹ������
	 * 	�ⲿ���ã�
	 * 		ֻҪ���÷���buildTree()����Ϊ��ȡ���е��������ݲ���ת��Ϊ���νṹ
	 * 	��ֲʹ�ã�
	 * 		1. �޸ı��Ӧ��ģ������ - PermRole
	 * 		2. �޸�getId��getTitle��getParentid�������ƣ���֤����
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<PermRole> list = this.getAll();
		logger.info(list.toString());
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<PermRole> tableData) {
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
    public List<NzTreeNode> tableData2NodeList(List<PermRole> tableData){
    	List<NzTreeNode> nodeList = new ArrayList<NzTreeNode>();
    	for (PermRole ele : tableData) {
			NzTreeNode node = new NzTreeNode();
			node.setKey(ele.getId());
			node.setTitle(ele.getName());
			node.setParentId(ele.getParentid());
			
			nodeList.add(node);
		}
    	logger.info(nodeList.toString());
    	return nodeList;
    }
    // ================================��ȡ���νṹ�������========================================

}
