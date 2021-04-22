package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/9
 */
public class JavaStringFuncDemo {

	public static void main(String[] args) {


		String a=" hello world ";

		String b="hello world";

		System.out.println(b.equals(a));

		a=a.trim();//去掉字符串首尾的空格

		System.out.println(a.equals(b));
	}
}
