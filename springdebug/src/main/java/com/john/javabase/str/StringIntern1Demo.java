package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/11
 */
public class StringIntern1Demo {

	public static void main(String[] args) {

		String s1 = new String("he") + new String("llo");//s1堆地址
	     String s2 = new String("h") + new String("ello");//s2堆地址，s1!=s2

	      //在常量池中找hello地址，没找到。
		  //故将当前字符串的地址（s1堆的地址）复制到字符串常量池中，并返回字符串常量池中的引用，也就是s1的地址。
		  String s3 = s1.intern(); //s3等于s1的堆地址
         //从字符串常量池中找，发现已经有hello地址，所以直接返回hello的地址，也就是s1
	     String s4 = s2.intern(); //s4等于s1的堆地址


		System.out.println(s1 == s3);// true
           System.out.println(s1 == s4);// true

		//s4已经等于s1的地址了 s4为首次出现hello时候放入常量池的引用
		System.out.println(s2 == s4 ); //false
	}
}
