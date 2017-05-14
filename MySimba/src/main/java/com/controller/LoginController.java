package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.EncryptUtil;
import com.model.User;
import com.service.IUserService;
import com.session.SessionUtil;

/**
 * 登录控制器
 * @author XUTAO
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Value("${administrator.username}")
	private String adminUserName;
	@Value("${administrator.password}")
	private String adminPassword;
	@Value("@{administrator.key}")
	private String key;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 进入登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		System.out.println("进入登录页面");
		if(SessionUtil.isLogin(request.getSession())){
			
		}
		return "login";
	}
	
	/**
	 * 登录页面
	 * @param userName 用户名
	 * @param password 密码
	 * @param model 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userName, String password, ModelMap model, HttpServletRequest request){
		System.out.println("开始登录"+userName+"||"+password);
		String view = "";
		if(StringUtils.isEmpty(userName)|| StringUtils.isEmpty(password)){
			view="login";
			model.put("errMsg", "用户名和密码不能为空");
		}else if(checkAccount(userName,password,request)){
			view="index";
		}else {
			view = "login";
			model.put("errMsg", "用户名或者密码错误");
		}
		model.put("userName", userName);
		model.put("password", password);
		return view;
	}

	/**
	 * 检查用户是否正确
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 */
	private boolean checkAccount(String userName, String password, HttpServletRequest request) {
		//检查是否是超级管理员
		boolean isAdmin = checkAdmin(userName, password);
		if(isAdmin){
			User user = new User();
			user.setAccount(userName);
			user.setName("超级管理员徐涛");
			SessionUtil.setUser(request.getSession(), user);
			SessionUtil.setAdmin(request.getSession());
			return true;
		}
		//去数据库检查数据
		userService.checkUser(userName, password);
		return false;
	}

	private boolean checkAdmin(String userName, String password) {
		System.out.println("adminUserName:="+adminUserName);
		String enU = EncryptUtil.md5(userName+key);
		System.out.println("enU+:"+enU);
		if(!adminUserName.equals(enU))
			return false;
		String enP = EncryptUtil.md5(password+key);
		if(!adminPassword.equals(enP))
			return false;
		
		return true;
	}
}
