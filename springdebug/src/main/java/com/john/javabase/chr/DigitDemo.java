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
		//Character.digit('c', 16)，表示输出字符'c'在16进制下实际的十进制数
		//https://www.practical-go-lessons.com/chap-8-variables-constants-and-basic-types
		//https://blog.csdn.net/weixin_36082485/article/details/53154065
		//http://www.voidcn.com/article/p-xkxpfebs-bwc.html
		int x=Character.digit('c', 16);
		System.out.println(x);//输出12

		String hex = "c";
		Integer y = Integer.parseInt(hex,16);

		System.out.println(y); //输出205

		//https://www.jianshu.com/p/619cb6fa376d
		String hex1 = "cd";
		Integer z = Integer.parseUnsignedInt(hex1,16);
		System.out.println(z); //输出205

		String hex2 = "zik0zj";
		Integer zz = Integer.parseUnsignedInt(hex2,36);
		//输出Integer的最大值为2147483647
		System.out.println(zz);


		String hex3 = "2147483648";
		Integer maxValue = Integer.parseUnsignedInt(hex3,10);
		//输出Integer的最大值为2147483647
//
		System.out.println(maxValue); //输出11259375
//		//2147483647
//		System.out.println(Integer.MAX_VALUE); //输出205

		//输出10在16进制下的字符表示
		System.out.println(Character.forDigit(10, 16));
		System.out.println(Character.forDigit(9, 16));

		System.out.println(Character.digit('g', 16));

		//https://www.fileformat.info/info/unicode/category/Nd/list.htm
		//https://blog.csdn.net/weixin_33693070/article/details/92747491
		int a = '0';
		System.out.println(a);

		System.out.println(Character.getType('0'));

		//https://blog.csdn.net/top_explore/article/details/95727488
		//是否是中日韩文字
		System.out.println(Character.isIdeographic('中'));

		char b = '\004'; //\u0004
		System.out.println(b);
	}
}
