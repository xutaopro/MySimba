package com.dao.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IUserDao;
import com.mapper.IMenuMapper;
import com.mapper.IUserMapper;
import com.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IUserMapper userMapper;
	
	@Autowired
	private IMenuMapper menuMapper;
	/*@Autowired
	private SqlSessionTemplate sqlSession;*/
	
	public int checkUser(String userName, String password) {
		/*System.out.println("dao......");
		System.out.println(userMapper);*/
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userName", userName);
		map.put("password", password);
		log.info("”√ªß£∫"+userMapper.checkUser(map));
		return userMapper.checkUser(map);
		/*HashMap<String, String> map = new HashMap<String, String>();
		int i = sqlSession.selectOne("", map);
		return i;*/
	}
	
	public int addUser(User user){
		int i = userMapper.addUser(user);
		return i;
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public int updateUser2(User user) {
		return menuMapper.updateUser(user);
	}
}
