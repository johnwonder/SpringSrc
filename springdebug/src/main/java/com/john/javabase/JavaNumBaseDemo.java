package com.john.javabase;

import java.text.DecimalFormat;
import java.text.Format;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/6
 */
public class JavaNumBaseDemo {

	public static void main(String[] args) {
		int num01  = 0b1100 ; //二进制 跟go一样
		int num02  = 014;   //八进制 //go中 用 0o14代表8进制
		int num03  = 0xC  ;  //十六进制 根go一样

		System.out.printf("2进制数 %b 表示的是: %d \n", num01, num01);
		System.out.printf("8进制数 %o 表示的是: %d \n", num02, num02);
		System.out.printf("16进制数 %X 表示的是: %d \n", num03, num03);

		Format moneyFormat=new DecimalFormat("##,##0.00");
		System.out.println(moneyFormat.format(Double.valueOf("0")) );

		System.out.println(moneyFormat.format(Double.valueOf("100005.756")) );

		Format orFormat =new DecimalFormat("##,###.00");
		System.out.println(orFormat.format(Double.valueOf("100005.756")) );

		int i = -2 & 3;//负数与正数 为正数 为2
		int j = -2 % 4;//为-2
		int ii = -5 >>> 2;
		System.out.println(i);
		System.out.println(j);
		System.out.println(ii);

		int m = 5 &3;
		int n = 5 %4;
		System.out.println(m);
		System.out.println(n);


		int mm = -5 &3; //
		int nn = -5 %4;
		System.out.println(mm); //3
		System.out.println(nn); //-1
		//取模不等于 与运算
		//https://developer.aliyun.com/article/772971?spm=a2c6h.12873581.0.0.12f2322ctvooSU&groupCode=java
	}
}
