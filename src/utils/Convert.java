package utils;

import java.sql.Date;

public class Convert {
	public static Date date(int year, int month, int day) {
		return new Date(year - 1900, month - 1, day);
	}
	
	public static Date date(Date date) {
		return new Date(date.getYear()-1900, date.getMonth() - 1, date.getDate());
	}
}
