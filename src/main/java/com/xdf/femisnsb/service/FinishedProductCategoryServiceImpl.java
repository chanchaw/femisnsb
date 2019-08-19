package com.xdf.femisnsb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xdf.femisnsb.model.NzTreeNode;
import com.xdf.femisnsb.dao.FinishedProductCategoryMapper;
import com.xdf.femisnsb.model.FinishedProductCategory;

@Service
public class FinishedProductCategoryServiceImpl implements IFinishedProductCategoryService {

	@Autowired
	private FinishedProductCategoryMapper dao;
	
	public int insert(FinishedProductCategory instance) {
		return dao.insert(instance);
	}

	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	public Integer updateByPrimaryKey(FinishedProductCategory instance) {
		return dao.updateByPrimaryKey(instance);
	}

	public FinishedProductCategory getByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<FinishedProductCategory> getAll() {
		return dao.selectAll();
	}

	public List<FinishedProductCategory> getAllValid() {
		return dao.selectAllValid();
	}

	public List<FinishedProductCategory> getAllInvalid() {
		return dao.selectAllInvalid();
	}
	
	public boolean isExist(Integer id) {
		FinishedProductCategory inst = getByPrimaryKey(id);
		if(inst == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isExist(String name) {
		List<FinishedProductCategory> list = dao.selectByName(name);

		if(list.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/*
	 * 	下面是4个方法组合是实现将DB表中数据集合转换为拥有父子关系的树形结构的数据
	 * 	外部调用：
	 * 		只要调用方法buildTree()，即为获取表中的所有数据并且转换为树形结构
	 * 	移植使用：
	 * 		1. 修改表对应的模型类型 - FinishedProductCategory
	 * 		2. 修改getId、getTitle、getParentid方法名称，保证可用
	 * @see com.xdf.femisnsb.service.IFinishedProductCategoryService#buildTree()
	 */
	public List<NzTreeNode> buildTree() {
		List<FinishedProductCategory> list = this.getAllValid();
		return buildTreeByList(list);
	}
	
    public List<NzTreeNode> buildTreeByList(List<FinishedProductCategory> tableData) {
    	Integer root = -1;// 根节点的值
    	
        List<NzTreeNode> nodeList = tableData2NodeList(tableData);
        List<NzTreeNode> tree = new ArrayList<NzTreeNode>();
        for (NzTreeNode treeNode : nodeList) {
            if (treeNode.getParentId() == root) {
                tree.add(getChildren(treeNode,nodeList));
            }
        }
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
    public List<NzTreeNode> tableData2NodeList(List<FinishedProductCategory> tableData){
    	List<NzTreeNode> nodeList = new ArrayList<NzTreeNode>();
    	for (FinishedProductCategory ele : tableData) {
			NzTreeNode node = new NzTreeNode();
			node.setKey(ele.getId());
			node.setTitle(ele.getTitle());
			node.setParentId(ele.getParentid());
			
			nodeList.add(node);
		}
    	return nodeList;
    }
    // ================================获取树形结构数据完毕========================================

    

}
