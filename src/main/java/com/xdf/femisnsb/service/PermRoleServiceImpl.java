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
	 * 	下面是4个方法组合是实现将DB表中数据集合转换为拥有父子关系的树形结构的数据
	 * 	外部调用：
	 * 		只要调用方法buildTree()，即为获取表中的所有数据并且转换为树形结构
	 * 	移植使用：
	 * 		1. 修改表对应的模型类型 - PermRole
	 * 		2. 修改getId、getTitle、getParentid方法名称，保证可用
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<PermRole> list = this.getAll();
		logger.info(list.toString());
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<PermRole> tableData) {
    	Integer root = 0;// 根节点的值
    	
        List<NzTreeNode> nodeList = tableData2NodeList(tableData);
        logger.info("模型集合转换为节点集合是：");
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
    // ================================获取树形结构数据完毕========================================

}
