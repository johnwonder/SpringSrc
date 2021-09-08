package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/11
 */
public class StringIntern4Demo {

	public static void main(String[] args) {

		//这篇文章还行的
		//https://www.cnblogs.com/liangyueyuan/p/9796992.html
		//
		String s3 =  "B" + "B";
		System.out.println(System.identityHashCode(s3));

		String s6 =  "BB";
		System.out.println(System.identityHashCode(s6));


		String ss = new StringBuilder().append("B").append("B").toString();
		System.out.println(System.identityHashCode(ss));

		String s4 =  new String("B") + new String("B");
		System.out.println(System.identityHashCode(s4));
		////加上s3后 s4.intern会直接取常量池的 不会把s4添加到常量池
		//不加s3 那么会把s4 添加到常量池 并返回s4的引用
		System.out.println(System.identityHashCode(s4.intern()));

		String s7 =  new String("B") + "B";
		System.out.println(System.identityHashCode(s7));//指向堆中的对象

		String s5 = "BB";
		System.out.println(System.identityHashCode(s5));

		System.out.println(s4 == s5);

		//不使用intern s4和 s5就不同

		//加上s3后 s4.intern 直接引用s3的常量值 ，也不会改变s4的值。
	}
}
