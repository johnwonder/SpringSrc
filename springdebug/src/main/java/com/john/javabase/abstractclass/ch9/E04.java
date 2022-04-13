package com.john.javabase.abstractclass.ch9;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/5
 */
abstract class E04A{}

class E04B extends E04A{
	public void hello(){
		System.out.println("E04B say hello!");
	}
}

abstract class E04A1{
	//抽象方法
	abstract public void hi();
}

class E04B1 extends E04A1{
	public void hi(){
		System.out.println("E04B1 say hi!");
	}
}

/**
 * https://blog.csdn.net/lanzijingshizi/article/details/84281110
 * 《Java编程思想》第9章 练习题
 */
public class E04 {
	static public void test(E04A e04){
		//must downcast
		//需要向下转型
		System.out.println("E04.test(): ");
		((E04B)e04).hello();

		//Class(java.lang.ClassLoader)' has private access in 'java.lang.Class'
		//私有构造函数
		//Class<String> e = new Class<String>();

	}

	static public void test1(E04A1 e041){
		//no downcast necessary
		//不需要向下转型
		System.out.println("E041.test1(): ");
		e041.hi();
	}

	public static void main(String[] args) {
		E04A e = new E04B();
		test(e);

		E04A1 e1 = new E04B1();
		test1(e1);
	}
}
