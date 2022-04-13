package com.john.javabase.reflect;

import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/23
 */
public class ClassDemo {

	private final int threadLocalHashCode = nextHashCode();
	private static AtomicInteger nextHashCode = new AtomicInteger();
	private static final int HASH_INCREMENT = 0x61c88647;
	private static int nextHashCode() {
		return nextHashCode.getAndAdd(HASH_INCREMENT);
	}
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		System.out.println(ClassDemo.class.getClassLoader());
		//Class cls = Class.forName("java.lang.String");
		//System.out.println(cls.getClass().getClassLoader());

		//System.out.println(ClassLoader.getSystemClassLoader());

//		for (int i = 0; i < 100; i++) {
//			ClassDemo demo = new ClassDemo();
//		}

		Class leafClass;
		Method[] declaredMethods = ReflectionUtils.getAllDeclaredMethods(SubClass.class);

		for (int i = 0; i < declaredMethods.length; i++) {

			if(declaredMethods[i].isBridge()){
				//
				Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(declaredMethods[i]);

				System.out.println(bridgedMethod == declaredMethods[0]);
			}
			System.out.println(declaredMethods[i].isBridge());
		}

		System.out.println(declaredMethods.length);
	}
}
