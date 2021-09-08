package com.john.javabase;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/4
 */
public class JavaClassLoaderDemo {

	public static void main(String[] args) {
//
//		FileSystemClassLoader fscl = new FileSystemClassLoader("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/java/com/john/javabase/");
//		try {
//			System.out.println(fscl.loadClass("com.john.javabase.ClassLoaderObj").newInstance());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		FileSystemClassLoader fscl1 = new FileSystemClassLoader("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/java/");
		FileSystemClassLoader fscl2 = new FileSystemClassLoader("/Users/zhangjiong/code/SpringSrc/springdebug/src/main/java/");
		try {
			Class cls1 = fscl1.loadClass("com.john.javabase.ClassLoaderObj");
			Class cls2 = fscl2.loadClass("com.john.javabase.ClassLoaderObj");
			System.out.println("class1: " + cls1);
			System.out.println("class2: " + cls2);

			//输出不相等。。
			System.out.println("class1 == class2? " + (cls1 == cls2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
