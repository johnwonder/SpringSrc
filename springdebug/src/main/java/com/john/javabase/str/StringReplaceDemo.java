package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/24
 */
public class StringReplaceDemo {

	public static void main(String[] args) {

		String objectName = "/awefaw/pic/xx.pdf";
		System.out.println(objectName.replaceAll("^.*/", ""));

		System.out.println("Accept-Encoding".toLowerCase());

		System.out.println("accept-encoding".toUpperCase());
	}
}
