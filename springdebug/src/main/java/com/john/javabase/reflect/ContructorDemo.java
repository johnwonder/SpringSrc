package com.john.javabase.reflect;

import java.lang.reflect.Constructor;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/25
 */
public class ContructorDemo {

	public static void main(String[] args) {


		Class<?> arrayClass= String[].class;
		//?话 newInstance就不知道啥类型

		Constructor<?>[] constructors = arrayClass.getDeclaredConstructors();

		//输出0
		System.out.println(constructors.length);

		//输出0
		Constructor<?>[] voidConstructors =  void.class.getDeclaredConstructors();
		System.out.println(voidConstructors.length);


	}
}
