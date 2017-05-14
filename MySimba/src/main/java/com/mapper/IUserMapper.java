package com.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.model.User;

@Component
public interface IUserMapper {

	public int checkUser(Map map);
	
	public int addUser(User user);
	
	public int updateUser(User user);
}
