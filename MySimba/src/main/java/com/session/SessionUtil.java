package com.session;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.common.util.PathUtil;
import com.model.User;

public class SessionUtil {

	// 存放session中的用户
	public static final String userKey = "sessUser";

	// 存在session里的标志，代表用户是否为超级管理员
	public static final String isAdminKey = "sessAdmin";

	// 存在session里的 用户有权限访问的所有的url地址的key
	public static final String permissionUrlKey = "sessPermissionUrls";

	/**
	 * 判断用户是否登录
	 * 
	 * @param session
	 * @return
	 */
	public static boolean isLogin(HttpSession session) {
		return getUser(session) != null;
	}

	public static User getUser(HttpSession session) {
		return (User) session.getAttribute("sessUser");
	}

	public static void setUser(HttpSession session, User user) {
		session.setAttribute(userKey, user);
	}

	public static void setAdmin(HttpSession session) {
		session.setAttribute(isAdminKey, true);
	}

	public static boolean isAdmin(HttpSession session) {
		Boolean isAdmin = (Boolean) session.getAttribute(isAdminKey);
		return isAdmin != null && isAdmin;
	}

	/**
	 * 
	 * @param session 得到session中用户有权限访问的url的key
	 * @param url
	 * @return
	 */
	public static boolean hasPermission(HttpSession session, String url) {
		boolean hasPermission = false;
		if (isAdmin(session)) {
			return true;
		}
		if (StringUtils.isBlank(url)) {
			return false;
		}
		Set<String> permissionUrlSet = SessionUtil.getPermissionUrl(session);
		for (String permissionUrl : permissionUrlSet) {
			if (PathUtil.mathch(url, permissionUrl)) {
				hasPermission = true;
				break;
			}
		}
		return hasPermission;
	}

	private static Set<String> getPermissionUrl(HttpSession session) {
		Set<String> set = (Set<String>) session.getAttribute(permissionUrlKey);
		return set != null ? set : new HashSet<String>(0);
	}
}
