package com.john.javabase.str;

import java.util.Arrays;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/10/26
 */
public class StringSplitDemo {

	public static void main(String[] args) {




		String s = "abfcdfefbb";

		System.out.println(Arrays.toString(s.split("")));

		String[] sp = s.split("",2);

		System.out.println(Arrays.toString(sp));
//		for (String s1 : sp) {
//			System.out.println(s1);
//		}

		String s1 = "ab.cdf.fbb";

		//如果要按.号来分割必须转义 如果不转义会当成正则来分隔
		String[] sp1 = s1.split("\\.",2);
		for (String s2 : sp1) {
			System.out.println(s2);
		}

		char ch = 'd';
	 	if((((ch -'0')|('9'-ch)) < 0 && ((ch-'a')|('z'-ch)) < 0 && ((ch-'A')|('Z'-ch)) < 0 )){
			System.out.println(ch);
		}

		String s2 = "ab(cdf9(bb";
		String[] sp2 = s2.split("\\(",1); //1直接返回字符串本身 跟go里一样
		System.out.println("----按正常字符分割");
		for (String s3 : sp2) {
			System.out.println(s3);
		}
		System.out.println("----按正常字符分割结束");

		//按数字正则来分割
		String sd = "ab2cdf9bb";
		String[] sp4 = sd.split("\\d");
		for (String s3 : sp4) {
			System.out.println(s3);
		}

		//按数字正则来分割
		String splitStr = "Have9834a908123great10891819081day!";
		String[] strs = splitStr.split("[0-9]+");
		for (String s3 : strs) {
			System.out.println(s3);
		}
	}
}
