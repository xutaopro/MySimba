package com.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * 序列化工具类
 * @author XUTAO
 *
 */
public class SerializeUtil {

	/**
	 * 对象序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object){
		if(object == null)
			return new byte[]{};
		ObjectOutputStream oOutputStream = null;
		ByteArrayOutputStream bOutputStream = null;
		try {
			bOutputStream = new ByteArrayOutputStream();
			oOutputStream = new ObjectOutputStream(bOutputStream);
			oOutputStream.writeObject(object);
			byte[] bytes = bOutputStream.toByteArray();
			return bytes;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	/**
	 * 对象的反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes){
		if(bytes==null || bytes.length==0)
			return null;
		ObjectInputStream oInputStream = null;
		ByteArrayInputStream baInputStream = new ByteArrayInputStream(bytes);
		try{
			oInputStream = new ObjectInputStream(baInputStream);
			Object object = oInputStream.readObject();
			return object;
		}catch(Exception e){
			throw  new RuntimeException(e.getMessage(),e);
		}
	}
}
