package com.dao;

import java.util.List;

import com.model.Menu;

public interface IMenuDao {

	List<Menu> listChildren(int parentID);

	/**
	 * 查找子节点个数
	 * @param id
	 * @return
	 */
	int getCount(int id);
}
