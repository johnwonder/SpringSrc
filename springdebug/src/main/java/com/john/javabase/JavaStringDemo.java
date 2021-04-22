package com.john.javabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		String remark = "[龚逸](14052936161303518)是 的 [范](14052936161303518)是 的";
		System.out.println(remark.replaceAll("\\[(\\S*)\\]\\(\\d*\\)", "@$1"));
		Pattern pattern = Pattern.compile("\\[(\\S*)\\]\\((\\d*)\\)"); //匹配@xxx(xxx)形态的字符串
		Matcher matcher=pattern.matcher(remark);
		while (matcher.find()) {
			String group=matcher.group(2);
			System.out.println(group);

			//System.out.println(group.substring(group.indexOf("(")+1,group.indexOf(")")));
		}


	}
}
