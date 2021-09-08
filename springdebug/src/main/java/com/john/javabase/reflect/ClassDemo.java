package com.john.javabase.reflect;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/23
 */
public class ClassDemo {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		System.out.println(ClassDemo.class.getClassLoader());
		//Class cls = Class.forName("java.lang.String");
		//System.out.println(cls.getClass().getClassLoader());

		//System.out.println(ClassLoader.getSystemClassLoader());
	}
}
