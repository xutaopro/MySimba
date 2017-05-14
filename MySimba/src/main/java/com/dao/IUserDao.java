package com.dao;

import com.model.User;

public interface IUserDao {

	int checkUser(String userName, String password);
	
	int addUser(User user);
	
	public int updateUser(User user);
	
	public int updateUser2(User user);

}
