package com.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author XUTAO
 *
 */
public class EncryptUtil {


	/**
	 * md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		
		return encode(str,"md5");
	}

	private static String encode(String str, String type) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(type);
			messageDigest.update(str.getBytes());
			byte[] digeStr = messageDigest.digest();
			String hex = byte2hex(digeStr);
			return hex;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	/**
	 * 将字节数组转换成16进制字符
	 * @param digeStr
	 * @return
	 */
	private static String byte2hex(byte[] b) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<b.length;i++){
			String temp = Integer.toHexString(b[i] &  0xff );//byte的大小为8bits而int的大小为32bits
			if(temp.length()==0){
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		
		return stringBuffer.toString().toUpperCase();
	}
}
