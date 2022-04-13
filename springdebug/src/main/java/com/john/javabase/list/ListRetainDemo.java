package com.john.javabase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/27
 */
public class ListRetainDemo {

	public static void main(String[] args) {

		List<String> strList1 = new ArrayList<>();
		List<String> strList2 = new ArrayList<>();
		strList1.add("1");
		//strList1.add("2");
		strList2.add("1");
		strList2.add("2");
		boolean result = strList1.retainAll(strList2);
		System.out.println(result);
		System.out.println(strList1);

		System.out.println(strList1.getClass().isArray());
	}
}
