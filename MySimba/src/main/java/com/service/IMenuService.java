package com.service;

import java.util.List;

import com.model.Menu;
import com.model.User;

public interface IMenuService {

	List<Menu> listChildren(int parentID);
	
	
}
