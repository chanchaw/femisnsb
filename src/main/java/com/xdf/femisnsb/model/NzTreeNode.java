package com.xdf.femisnsb.model;

import java.util.List;

public class NzTreeNode {
	
	
	@Override
	public String toString() {
		return "NzTreeNode [key=" + key + ", title=" + title + ", parentId=" + parentId + ", children=" + children
				+ "]";
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public List<NzTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<NzTreeNode> children) {
		this.children = children;
	}
	private Integer key; // 这里是主键
	private String title; // 标题，文本
	private Integer parentId; // 所属上级
	private List<NzTreeNode> children;

	
}
