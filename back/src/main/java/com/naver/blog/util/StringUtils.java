package com.naver.blog.util;

public class StringUtils {
	
	public static boolean isNull(String str) {
		boolean isNull = (str == null || "".equals(str) || "null".equals(str));
		
		return isNull;
	}
}
