package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/7
 */
public class JavaCharDemo {

	public static void main(String[] args) {

//		16 位编码的所有 65，536 个字符并不能完全表示全世界所有正在使用或曾经使用的字符。于是，Unicode 标准已扩展到包含多达 1，112，064 个字符。那些超出原来的16 位限制的字符被称作增补字符。
//
//Java的char类型是固定16bits的。代码点在U+0000 — U+FFFF之内到是可以用一个char完整的表示出一个字符。但代码点在U+FFFF之外的，一个char无论如何无法表示一个完整字符。这样用char类型来获取字符串中的那些代码点在U+FFFF之外的字符就会出现问题。
//
//因此，Java 平台不仅需要支持增补字符，而且必须使应用程序能够方便地做到这一点。Java Community Process 召集了一个专家组，以期找到一个适当的解决方案。该小组被称为JSR-204专家组，使用Unicode 增补字符支持的Java技术规范请求的编号。
//
//增补字符是代码点在 U+10000 至 U+10FFFF 范围之间的字符，也就是那些使用原始的 Unicode 的 16 位设计无法表示的字符。从 U+0000 至 U+FFFF 之间的字符集有时候被称为基本多语言面 （BMP UBasic Multilingual Plane ）。因此，每一个 Unicode 字符要么属于 BMP，要么属于增补字符

//		原文链接：https://blog.csdn.net/mazhimazh/article/details/17708001
		//因为 大于 Character.MIN_SUPPLEMENTARY_CODE_POINT
		int  suppleCodePoint = 0x010001;
		char[] chars = Character.toChars(suppleCodePoint);

		System.out.println(chars.length);

		char c = Character.toUpperCase('\u212A');
		char c1 =Character.toUpperCase('k');
		System.out.println(c);
		System.out.println(c1);

		char c2 = Character.toLowerCase('\u212A');
		char c3 =Character.toLowerCase('k');
		System.out.println(c2);
		System.out.println(c3);


		System.out.println(Character.toUpperCase('\u212A')== Character.toUpperCase('k'));//false
		System.out.println(Character.toLowerCase('\u212A') == Character.toLowerCase('K'));//true
		//System.out.println((Character.'\u212A' == 'k'));

		String s1 = "K";
		String s2 = "K";
		String s3 = "K";

		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));

		int i = -1>>>1;
		System.out.println(i);

		int j = 0x7FFFFFFF;
		System.out.println(j);

		//Latin1是ISO-8859-1的别名，有些环境下写作Latin-1。ISO-8859-1编码是单字节编码
		//Latin1 字符编码
		//CharacterData.of里学到
//		if (ch >>> 8 == 0) {     // fast-path
//			return CharacterDataLatin1.instance;
//		}
		//Latin1是ISO-8859-1的别名，有些环境下写作Latin-1。ISO-8859-1编码是单字节编码，向下兼容ASCII，
		// 其编码范围是0x00-0xFF，0x00-0x7F之间完全和ASCII一致，0x80-0x9F之间是控制字符，0xA0-0xFF之间是文字符号。
	}
}
