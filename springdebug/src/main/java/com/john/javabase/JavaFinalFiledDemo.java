package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/13
 */
public class JavaFinalFiledDemo {

	//没初始化是可以在构造函数里初始化的
	private  final String field ;

	public JavaFinalFiledDemo(String field) {
		this.field = field;
	}
}
