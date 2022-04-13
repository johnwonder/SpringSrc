package com.john.javabase;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public class TestHashCode {

	//https://blog.csdn.net/zh921112/article/details/34807145
	public static void main(String[] args) {


		int i = 170;
		System.out.println("Number = " + i);

     	/* returns the string representation of the unsigned integer value
     	represented by the argument in hexadecimal (base 16) */
		//aa 代表 10*16 + 10
		System.out.println("Hex = " + Integer.toHexString(i));

		String a = new String("hhh");
		String b = new String("hhh");

		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		System.out.println("CGLIB$g$1".hashCode() ^ "()V".hashCode());

		System.out.println("CGLIB$g$1()V".hashCode());
	}
}
