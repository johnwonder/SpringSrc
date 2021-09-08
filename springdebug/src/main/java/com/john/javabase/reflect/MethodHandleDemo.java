package com.john.javabase.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/13
 */
public class MethodHandleDemo {

	//https://blog.csdn.net/wulianzhazha/article/details/78815647
	//openfeign

	//https://blog.csdn.net/prestigeding/article/details/90415680
	//mybatis
	public static void main(String[] args) throws Throwable {

		//声明定义方法的签名，参数为返回值类型、参数类型
		MethodType methodType = MethodType.methodType(void.class, String.class);
		//声明定义方法句柄，通过lookup对象得到方法句柄，参数为方法所在的类、方法的名称、所匹配的方法签名
		MethodHandle methodHandle = methodHandle = MethodHandles.lookup().findVirtual(Hello.class, "sayHello", methodType);
		//调用底层方法
		methodHandle.invoke(Hello.class.newInstance(), "Test");
	}
}

class Hello {
	public void sayHello(String str) {
		System.out.println("SayHello Method.."+str);
	}
}
