package com.common.util;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.model.Menu;
import com.sun.istack.internal.logging.Logger;

/**
 * json处理类
 * @author XUTAO
 *
 */
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Log logger = LogFactory.getLog(JsonUtil.class);

	
	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("Object转换json失败");
		}
		
		return null;
	}

	
}
