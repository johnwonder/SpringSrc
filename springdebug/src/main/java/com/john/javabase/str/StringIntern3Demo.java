package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/11
 */
public class StringIntern3Demo {

	public static void main(String[] args) {

		String s1 = new String("AA");
		System.out.println(System.identityHashCode(s1.intern()));
		String s2 = "AA";
		System.out.println(System.identityHashCode(s2));

		System.out.println(s1 == s2);


	}
}
