package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/26
 */
public class NumberPromotion {

	public static void main(String[] args) {

		double a = 1.25D;
		long b = 2L;
		//可能有信息丢失的转换
 		double c = b;
		System.out.println(c);

		System.out.println( getType(a + b));
	}

	//https://www.cnblogs.com/fps2tao/p/12742274.html
	private static String getType(Object a) {
		return a.getClass().toString();

	}
}
