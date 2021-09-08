package com.john.javabase.str;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/11
 */
public class StringInternDemo{

	//https://www.cnblogs.com/flyingrun/p/12781257.html
	public static void main(String[] args) {

//		String s3 = new String("xyz");
//		String s4 = new String("xyz");
//		System.out.println(s3==s4);
//		System.out.println(s3.equals(s4));

		//https://blog.csdn.net/u013366617/article/details/83618361

		//常量池上存在引用AABB
		String a =  "AAB" + "B";
		System.out.println(System.identityHashCode(a));

		String a4 = new String("AAB") + new String("B"); //不会去常量池
		//String中的intern方法是一个 native 的方法，
		// 当调用 intern方法时，如果常量池已经包含一个等于此String对象的字符串，则返回池中的字符串。
		// 否则，将intern返回的引用指向当前字符串 s1(jdk1.6版本需要将 s1 复制到字符串常量池里)
		System.out.println(System.identityHashCode(a4));
		System.out.println(System.identityHashCode(a4.intern()));
		String a5 = "AA" + "BB"; //常量池找到了a4的地址
		System.out.println(a4 == a5); //true
		System.out.println(System.identityHashCode(a4));
		System.out.println(System.identityHashCode(a5));


		String a1 =  new String("AABB"); //
		System.out.println(System.identityHashCode(a1.intern()));
		String a2 = "AABB"; //常量池找到了a4的地址

		System.out.println("a1:"+System.identityHashCode(a1)); //不会去常量池创建
		System.out.println(System.identityHashCode(a2));
		System.out.println(a1 == a2); //true

		//这种方式会保证字符串常量池和堆中都有这个对象，没有就创建，最后返回堆内存中的对象引用。因为有"abc"这个字面量，所以会先检查字符串常量池中是否存在字符串"abc" 。如果不存在，先在字符串常量池里创建一个字符串对象；再去内存中创建一个字符串对象"abc"；存在的话，就直接去堆内存中创建一个字符串对象"abc"；最后，将内存中的引用返回。
		//————————————————
		//版权声明：本文为CSDN博主「Malong Wu」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
		//原文链接：https://blog.csdn.net/weixin_35235724/article/details/112080445
		String s1 = new String("1");
		String s2 = "1";
		//s1.intern();
		System.out.println(s1 == s2);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";

		System.out.println(s3 == s4);
	}
}
