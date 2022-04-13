package com.john.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/31
 */
public class CglibTest1 {
	interface IService1 {

		void m1();
	}

interface IService2 {
	void m2();
}

//https://blog.csdn.net/psd0503/article/details/107116881/
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		//设置代理对象需要实现的接口
		enhancer.setInterfaces(new Class[]{IService1.class, IService2.class});
		//通过Callback来对被代理方法进行增强
		enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
			//报NoSuchMethodError
			//methodProxy.invokeSuper(o,objects);
			System.out.println("方法：" + method.getName());
			return null;
		});
		Object proxy = enhancer.create();
		if (proxy instanceof IService1) {
			((IService1) proxy).m1();
		}
		if (proxy instanceof IService2) {
			((IService2) proxy).m2();
		}
		//看一下代理对象的类型
		System.out.println(proxy.getClass());
		//看一下代理类实现的接口
		System.out.println("创建代理类实现的接口如下：");
		for (Class<?> cs : proxy.getClass().getInterfaces()) {
			System.out.println(cs);
		}
	}
}
