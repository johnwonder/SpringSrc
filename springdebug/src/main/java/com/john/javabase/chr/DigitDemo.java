package com.john.javabase.chr;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/26
 */
public class DigitDemo {

	public static void main(String[] args) {

		//http://www.blogjava.net/wenjiale/archive/2008/09/26/231270.html
		//https://blog.csdn.net/wolfking0608/article/details/72775016
		//Character.digit('c', 16)，表示输出字符'c'代表的16进制数
		//https://www.practical-go-lessons.com/chap-8-variables-constants-and-basic-types
		//https://blog.csdn.net/weixin_36082485/article/details/53154065
		//http://www.voidcn.com/article/p-xkxpfebs-bwc.html
		int x=Character.digit('c', 16);
		System.out.println(x);
	}
}
