package com.model;

import java.io.Serializable;

/**
 * 菜单树形结构
 * @author XUTAO
 *
 */
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String text;
	/**
	 * 父节点id
	 */
	private int parentID;
	
	/**
	 *菜单url地址 
	 */
	private String url;
	/**
	 * 排序
	 */
	private int orderNo;
	
	//扩展属性，给EXTjs使用
	private boolean leaf;//本节点是否还有节点
	
	private String state;//状态
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
