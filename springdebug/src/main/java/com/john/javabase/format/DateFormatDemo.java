package com.john.javabase.format;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/2/22
 */
public class DateFormatDemo {

	public static void main(String[] args) {

		DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
		String date4 = df4.format(new Date());

		DateFormat df8 = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
		String time4 = df8.format(new Date());
		System.out.println("LONG：" + date4 + " " + time4);
	}
}
