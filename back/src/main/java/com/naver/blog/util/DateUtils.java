package com.naver.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	static final SimpleDateFormat yyyyMmDdHhMmSsSdf = new SimpleDateFormat("YYYYMMddHHmmss");
	
	public static String getCurrentDateYyyyMmDdHhMiSs() {
		String currentInfo = null;
		Date date = new Date();
		currentInfo = yyyyMmDdHhMmSsSdf.format(date);
		
		return currentInfo;
	}
}
