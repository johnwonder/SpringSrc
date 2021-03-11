package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/7
 */
public class JavaStringDemo {

	public static void main(String[] args) {

		StringBuffer stringBuffer = new StringBuffer("hello world");
		String strBuffer = new String(stringBuffer);

		System.out.println(strBuffer);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("hello");

		String builderStr = new String(stringBuilder);
		System.out.println(builderStr);
	}
}
