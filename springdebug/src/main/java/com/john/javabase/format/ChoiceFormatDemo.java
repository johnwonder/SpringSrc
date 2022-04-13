package com.john.javabase.format;

import java.text.ChoiceFormat;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/2/24
 */
public class ChoiceFormatDemo {

	public static void main(String[] args) {
		double[] key = {3,4,5,6,7,8,9};
		String[] weekday = {"周一","周二","周三","周四","周五","周六","周天"};

		ChoiceFormat format = new ChoiceFormat(key, weekday);

		/**3.6介于3和4之间，所以会匹配3，又由于3在limits数组中的索引是0，所以会在formats数组徐照索引0的值，即输出"星期一"
		 */
		System.out.println(format.format(2));	//输出：周一
		System.out.println(format.format(3.2)); //输出：周一
		System.out.println(format.format(5));   //输出：周三
		System.out.println(format.format(9.9)); //输出：周天
		System.out.println(format.format(10));  //输出：周天

		//原文链接：https://blog.csdn.net/rocling/article/details/81783850
	}
}
