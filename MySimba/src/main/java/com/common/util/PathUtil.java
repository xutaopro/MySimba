package com.common.util;

import org.springframework.util.AntPathMatcher;

/**
 * URL路径工具类
 * @author XUTAO
 *
 */
public class PathUtil {

	public static AntPathMatcher match = new AntPathMatcher();
	
	/**
	 * 判断目标url和ant的url路径是否匹配
	 * @param targetUrl 具体url
	 * @param antPath 匹配
	 * @return
	 */
	public static boolean mathch(String targetUrl, String antPath) {
		return match.match(antPath, targetUrl);
	}

}
