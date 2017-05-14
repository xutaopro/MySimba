package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IMenuDao;
import com.dao.IUserDao;
import com.model.Menu;
import com.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;
	public List<Menu> listChildren(int parentID) {
		List<Menu> menuList =  menuDao.listChildren(parentID);
		for(Menu menu:menuList){
			//判断这颗树是否是末节点
			int children = menuDao.getCount(menu.getId());
			if(children>0){
				menu.setLeaf(false);
				menu.setState("closed");
			}else{
				menu.setLeaf(true);
				menu.setState("open");
			}
		}
		return menuList;
	}

}
