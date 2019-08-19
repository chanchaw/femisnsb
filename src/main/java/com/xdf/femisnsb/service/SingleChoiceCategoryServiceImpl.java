/**  
 * All rights Reserved, Designed By www.xdfsoft.com
 * @Title:  SingleChoiceCategoryServiceImpl.java   
 * @Package com.xdf.femisnsb.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:15:06   
 * @version V1.0 
 * @Copyright: 2018 www.xdfsoft.com Inc. All rights reserved. 
 * 注意：常熟市新东方智能化系统工程有限公司
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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: chanchaw
 * @date:   2018年12月20日 下午11:15:06   
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
	 * 	下面是4个方法组合是实现将DB表中数据集合转换为拥有父子关系的树形结构的数据
	 * 	外部调用：
	 * 		只要调用方法buildTree()，即为获取表中的所有数据并且转换为树形结构
	 * 	移植使用：
	 * 		1. 修改表对应的模型类型 - SingleChoiceCategory
	 * 		2. 修改getId、getTitle、getParentid方法名称，保证可用
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<SingleChoiceCategory> list = this.getAll();
		logger.info(list.toString());
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<SingleChoiceCategory> tableData) {
    	Integer root = 1;// 根节点的值
    	
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
    // ================================获取树形结构数据完毕========================================
    

}
