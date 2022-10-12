package com.john.javabase.chr;

import java.nio.charset.StandardCharsets;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/7/18
 */
public class StringToIntDemo {

	public static void main(String[] args) {


		String s = "100";

		System.out.println(Atoi(s));
	}

	private static int Atoi(String s){

		int n = 0;
		byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
		for (byte ch : bytes) {
			ch -= '0';
			if (ch > 9) {
				return 0;
			}
			n = n*10 + ch;
		}
		return n;
	}
}
