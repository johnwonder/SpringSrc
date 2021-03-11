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
	}
}
