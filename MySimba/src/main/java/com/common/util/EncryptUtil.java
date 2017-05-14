package com.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ���ܹ�����
 * @author XUTAO
 *
 */
public class EncryptUtil {


	/**
	 * md5����
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
	 * ���ֽ�����ת����16�����ַ�
	 * @param digeStr
	 * @return
	 */
	private static String byte2hex(byte[] b) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<b.length;i++){
			String temp = Integer.toHexString(b[i] &  0xff );//byte�Ĵ�СΪ8bits��int�Ĵ�СΪ32bits
			if(temp.length()==0){
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		
		return stringBuffer.toString().toUpperCase();
	}
}
