package com.dao;

import java.util.List;

import com.model.Menu;

public interface IMenuDao {

	List<Menu> listChildren(int parentID);

	/**
	 * �����ӽڵ����
	 * @param id
	 * @return
	 */
	int getCount(int id);
}
