package com.john.javabase.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/27
 */
public class StaticMethodInvokeDemo {

	public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

		Class<?> threadClazz = Class.forName("java.lang.Math");
		Method method = threadClazz.getMethod("abs", long.class);
		System.out.println(method.invoke(null, -10000l));

		//通过getDeclaredMethod
		Method method1 = Math.class.
				getDeclaredMethod("abs", long.class);

		Object invoke = method.invoke(null, -50); // obj 传 null
		System.out.println(invoke); // invoke|invoke

	}
}
