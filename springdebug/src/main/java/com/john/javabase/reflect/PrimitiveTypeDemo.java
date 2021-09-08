package com.john.javabase.reflect;

import java.util.Date;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/2
 */
public class PrimitiveTypeDemo {

	public static void main(String[] args) {

		//返回false
		System.out.println(Boolean.class.isPrimitive());

		//返回true
		System.out.println(boolean.class.isPrimitive());

		//Date d = new Date();

		System.out.println(Date.class.isAssignableFrom(Date.class));
	}
}
