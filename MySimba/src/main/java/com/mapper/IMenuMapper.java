package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Menu;
import com.model.User;

public interface IMenuMapper {

	//·µ»ØlistÊ÷
	public List<Menu> listChildren(int parentID);

	public int getCount(int id);
	
	public int updateUser(User user);
	
}
