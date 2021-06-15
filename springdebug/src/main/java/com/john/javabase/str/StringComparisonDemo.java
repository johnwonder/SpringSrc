package com.john.javabase.str;

import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
public class StringComparisonDemo {

	public static void main(String[] args) {

		String foo ="ABC";

		String bar1 = "ABC";
		String bar2 = "ABCD";
		String bar3 = "ABCDE";

		System.out.println(foo.compareTo(bar1));
		System.out.println(foo.compareTo(bar2));
		System.out.println(foo.compareTo(bar3));

		String foo1 ="GCDF";
		System.out.println(foo1.compareTo(bar2));
	}
}
