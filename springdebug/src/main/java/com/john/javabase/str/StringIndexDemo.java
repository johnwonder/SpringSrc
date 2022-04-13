package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/10/12
 */
public class StringIndexDemo {

	public static void main(String[] args) {

		String s = "abcdde";

		System.out.println(s.lastIndexOf("cd"));

		System.out.println(s.lastIndexOf(""));

		System.out.println(s.startsWith("d", 3));

		//输出3
		System.out.println(strCount("absfsdfabsdfosfabsfspfoj","ab"));

		System.out.println(getStrCount("absfsdfabsdfosfabsfspfoj", "ab"));
	}


	public  static  int  strCount(String str,String subStr){

		// 获取原始字符串的长度
		int oldCount = str.length();
		// 将 ab 替换为空之后字符串的长度
		int newCount = str.replace(subStr, "").length();
		// 由于统计的字符串长度是2，所以出现的次数要除以要统计字符串的长度
		return  (oldCount - newCount) / subStr.length();  //=>3
	}

	private static int getStrCount(String mainStr, String subStr) {
		// 声明一个要返回的变量
		int count = 0;
		// 声明一个初始的下标，从初始位置开始查找
		int index = 0;
		// 获取主数据的长度
		int mainStrLength = mainStr.length();
		// 获取要查找的数据长度
		int subStrLength = subStr.length();
		// 如果要查找的数据长度大于主数据的长度则返回0
		if (subStrLength > mainStrLength) return 0;
		// 循环使用indexOf查找出现的下标，如果出现一次则count++
		while ((index = mainStr.indexOf(subStr, index)) != -1) {
			count++;
			// 从找到的位置下标加上要查找的字符串长度，让指针往后移动继续查找
			index += subStrLength;
		}
		return count;
	}

}
