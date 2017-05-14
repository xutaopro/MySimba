package com.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IMenuDao;
import com.mapper.IMenuMapper;
import com.model.Menu;

@Repository
public class MenuDaoImpl implements IMenuDao {

	@Autowired
	private IMenuMapper menuMapper;
	
	public List<Menu> listChildren(int parentID) {
		System.out.println("¿ªÊ¼²éÕÒÊ÷");
		return menuMapper.listChildren(parentID);
		
	}

	public int getCount(int id) {
		// TODO Auto-generated method stub
		return menuMapper.getCount(id);
	}

}
