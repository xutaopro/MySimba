package com.model;

import java.io.Serializable;

/**
 * �˵����νṹ
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
	 * ���ڵ�id
	 */
	private int parentID;
	
	/**
	 *�˵�url��ַ 
	 */
	private String url;
	/**
	 * ����
	 */
	private int orderNo;
	
	//��չ���ԣ���EXTjsʹ��
	private boolean leaf;//���ڵ��Ƿ��нڵ�
	
	private String state;//״̬
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
