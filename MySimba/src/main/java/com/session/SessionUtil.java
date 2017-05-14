package com.session;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.common.util.PathUtil;
import com.model.User;

public class SessionUtil {

	// ���session�е��û�
	public static final String userKey = "sessUser";

	// ����session��ı�־�������û��Ƿ�Ϊ��������Ա
	public static final String isAdminKey = "sessAdmin";

	// ����session��� �û���Ȩ�޷��ʵ����е�url��ַ��key
	public static final String permissionUrlKey = "sessPermissionUrls";

	/**
	 * �ж��û��Ƿ��¼
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
	 * @param session �õ�session���û���Ȩ�޷��ʵ�url��key
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
