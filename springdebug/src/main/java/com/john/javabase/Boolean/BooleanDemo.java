package com.john.javabase.Boolean;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/30
 */
public class BooleanDemo {

	public static void main(String[] args) {

		Boolean b = Boolean.logicalXor(false,false);
		System.out.println(b);

		char c1 = 'a';
		char c2 = 'A';
		if (c1 == c2 || true && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {

			System.out.println("true");
		}

		String tranCodeSuffix = "JOB_UPDATE".substring("JOB_UPDATE".lastIndexOf("_"));
		System.out.println(tranCodeSuffix);

	}
}
