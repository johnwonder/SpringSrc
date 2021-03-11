package com.john.javabase;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2021/2/21
 */
public class TestLinedHashSet {

	public static void main(String[] args) {

		int h =1290846991;
		int hash = h ^ (h >>> 16);

		System.out.println(hash);

		Set<String> arr=new LinkedHashSet<>();


		arr.add("aaaaa");
		arr.add("bbbbb");

		arr.add("aaaaa");

		//还是按照插入顺序来
		for (String a : arr){
			System.out.println(a);
		}

	}
}
