package com.common.util;

import org.springframework.util.AntPathMatcher;

/**
 * URL·��������
 * @author XUTAO
 *
 */
public class PathUtil {

	public static AntPathMatcher match = new AntPathMatcher();
	
	/**
	 * �ж�Ŀ��url��ant��url·���Ƿ�ƥ��
	 * @param targetUrl ����url
	 * @param antPath ƥ��
	 * @return
	 */
	public static boolean mathch(String targetUrl, String antPath) {
		return match.match(antPath, targetUrl);
	}

}
