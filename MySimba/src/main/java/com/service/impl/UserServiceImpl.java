package com.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.EncryptUtil;
import com.dao.IUserDao;
import com.model.User;
import com.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	 private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IUserDao userDao;
	
	public boolean checkUser(String userName, String password) {
		log.info("开始service服务");
		//password = EncryptUtil.md5(password);
		return userDao.checkUser(userName,password)>=1;
	}

	public int addUser(User user) {
		log.info("开始service服务");
		int i =userDao.addUser(user);
		return i;
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	public int updateUser2(User user) {
		return userDao.updateUser2(user);
	}
}
