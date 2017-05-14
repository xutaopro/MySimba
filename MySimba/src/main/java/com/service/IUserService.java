package com.service;

import com.model.User;

public interface IUserService {

	/**
	 * ����û��Ƿ����
	 * @param username �û���
	 * @param password ����
	 * @return
	 */
	boolean checkUser(String userName,String password);
	
	
	int addUser(User user);
	
	public int updateUser(User user);
	
	/**
	 * ʹ����һ��mapper
	 * @param user
	 * @return
	 */
	public int updateUser2(User user);
}
