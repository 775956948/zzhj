package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	
	public static String format(Date str){
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		return f.format(str);
	}
}
