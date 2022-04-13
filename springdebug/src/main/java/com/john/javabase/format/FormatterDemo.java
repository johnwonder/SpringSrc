package com.john.javabase.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/28
 */
public class FormatterDemo {

	public static void main(String[] args) {

		for (int i = 0; i < 12; i++) {
			System.out.printf("%03d%n", i + 1);
		}


		//输出了百分比%  和换行符 内部也是Formatter调用
		System.out.printf("百分比：%d %%%n", 20);

		Calendar c = Calendar.getInstance();
//		//1$ 代表取第一个参数
//		String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
//		System.out.println(s1);
//
//		//标记 < 代表取前一个参数 跟上面的一样
//		String s2 = String.format("Duke's Birthday: %1$tm %\u003cte,%<tY", c);
//		System.out.println(s2);

		Calendar c1 = Calendar.getInstance();
		//c1.add(Calendar.MONTH,-6);
		c1.set(2022,10,15);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c1.getTime()));
		//$1貌似只管取 %< 也只管取
		String s3 = String.format("Duke's Birthday: %2$tm %te,%<tY", c,c1);
		System.out.println(s3);

		//go中通过[1] 来显示获取索引处的值
	}
}
