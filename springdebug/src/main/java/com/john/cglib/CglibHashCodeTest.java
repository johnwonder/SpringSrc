package com.john.cglib;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/10/29
 */
public class CglibHashCodeTest {

	public static void main(String[] args) {


		System.out.println((CglibHashCodeTest.class instanceof Class));

		System.out.println("g()V".hashCode());

		int a=2;
		System.out.println("a 非的结果是："+(~a));

		// 0010

		// 1101

		// 取反 0010  加1 0011
	}
}
