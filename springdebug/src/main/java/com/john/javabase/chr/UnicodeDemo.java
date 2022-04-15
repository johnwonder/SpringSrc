package com.john.javabase.chr;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/15
 */
public class UnicodeDemo {

	public static void main(String[] args) {


		String s = "😂";
		System.out.println(s);
		System.out.println(s.length());//输出2 char的数量

		System.out.println(Character.isLetter('\uD840')); //false
		System.out.println(Character.isSurrogate('\uD840'));//true
		System.out.println(Character.isHighSurrogate('\uD840')); //true
		System.out.println(Character.isLowSurrogate('\uD840')); //false

		String apple = "苹果";
		System.out.println(apple.length());
	}
}
