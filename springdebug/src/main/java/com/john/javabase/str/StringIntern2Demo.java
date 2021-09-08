package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/11
 */
public class StringIntern2Demo {

	public static void main(String[] args) {

		String s1 = new String("he") + new String("llo");//s1堆地址
		//s1.intern();
	     String s2 = new String("h") + new String("ello");//s2堆地址，s1!=s2

		//在常量池中找hello地址，没找到。
		String s3 = "h" +"ello";
		String s5 = s1.intern(); //找到的是 s3的地址

         //从字符串常量池中找，发现已经有hello地址，所以直接返回hello的地址，也就是s3
	     String s4 = s2.intern(); //s4等于s3的堆地址

		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		System.out.println(System.identityHashCode(s5));




		System.out.println(s1 == s3);// true
           System.out.println(s1 == s4);// true
	}
}
