package com.john.javabase.chr;

import java.nio.charset.Charset;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/20
 */
public class CharDemo1 {

	public static void main(String[] args) {

		//https://blog.csdn.net/ocean20/article/details/6743385
		//在Java内部进行字符处理时，采用的都是Unicode，具体编码格式是UTF-16BE。
		// 简单回顾一下，UTF-16使用两个或4个字节表示一个字符，Unicode编号范围在65536以内的占两个字节，超出范围的占4个字节，
		// BE就是先输出高位字节，再输出低位字节，这与整数的内存表示是一致的。
		char a = 'A';
		char b = '张';
		char c = 0x5f20;
		char d = '\u5f20';

		System.out.println(a);
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b)); //输出101111100100000
		System.out.println(String.valueOf(b)); //输出张
		System.out.println(Integer.toHexString(b)); //输出5f20
		System.out.println(c); //输出张
		System.out.println(d); //输出张

		System.out.println(String.valueOf(d));//张
		System.out.println("-------------------"); //输出5f20
		char e = 39532;
		char f = 0x9a6c;
		char g = '\u9a6c';
		System.out.println(e);//输出 马
		System.out.println(f);//输出 马
		System.out.println(g);//输出 马

		//char h = '\uD842\uDFB7'; //两个字符 不行。。 𠮷
		int cp = 0x20BB7;
		//char h = '\u29BB7'; 错误
		System.out.println(Integer.toHexString(cp));

	}
}
