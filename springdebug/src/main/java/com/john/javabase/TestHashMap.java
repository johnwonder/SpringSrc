package com.john.javabase;

import java.util.HashMap;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/11
 */
public class TestHashMap {

	public static void main(String[] args) {
		HashMap arr=new HashMap();
		String a="111";
		String b=new String("111");

		System.out.println(a);
		System.out.println(b);
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println("a的hashcode:" + a.hashCode());
		System.out.println("b的hashcode:" + b.hashCode());
		arr.put(a,"aaaaa");
		arr.put(b,"bbbbb");
		System.out.println(arr);
		System.out.println(arr.get(a));
	}
}
