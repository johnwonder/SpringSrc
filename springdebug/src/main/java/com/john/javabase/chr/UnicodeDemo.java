package com.john.javabase.chr;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/15
 */
public class UnicodeDemo {

	public static void main(String[] args) {


		String s = "😂";
		System.out.println(s);
		System.out.println(s.length());//输出2 char的数量

		System.out.println(Character.isLetter('\uD840')); //false
		System.out.println(Character.isSurrogate('\uD840'));//true
		System.out.println(Character.isHighSurrogate('\uD840')); //true
		System.out.println(Character.isLowSurrogate('\uD840')); //false

		String apple = "苹果";
		System.out.println(apple.length());

		System.out.println(Character.isLetter(0xD7FF));
	//    int data = Integer.parseInt("\uD7FF", 16);
	//    System.out.println(((char) data));

		//https://blog.csdn.net/qq_46437309/article/details/116240262
		//https://www.jianshu.com/p/53541c5b97f7
		//https://mp.weixin.qq.com/s/5pAgcjk_lFGrPhSUp2Na3Q
		//输出HANGUL_JAMO_EXTENDED_B
		Character.UnicodeBlock of = Character.UnicodeBlock.of(0xD7FF);
		System.out.println(of);
	}
}
