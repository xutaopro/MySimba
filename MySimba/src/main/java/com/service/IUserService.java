package com.service;

import com.model.User;

public interface IUserService {

	/**
	 * 检查用户是否存在
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	boolean checkUser(String userName,String password);
	
	
	int addUser(User user);
	
	public int updateUser(User user);
	
	/**
	 * 使用另一个mapper
	 * @param user
	 * @return
	 */
	public int updateUser2(User user);
}
