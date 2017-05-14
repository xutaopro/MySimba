package com.dataSoure;


public class MultiDataSource{

	private static final ThreadLocal<String> local = new ThreadLocal<String>();
	
	public static void clear(){
		local.remove();
	}
	
	public static void set(String source){
		local.set(source);
	}
	
	public static String get(){
		return local.get();
	}
}
