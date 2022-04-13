package com.john.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/25
 */
public class ProxyClassDemo {

	//这种方法跟Proxy.newInstance 异曲同工
	//因为Proxy.newInstance内部也是通过 getProxyClass0去获取代理类，然后根据构造函数去生成一个代理实例
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		//参考 https://ytao.top/2020/04/05/20-java-proxy
//		1.调用Proxy.getProxyClass方法获取代理类的Class对象
//		2.使用InvocationHandler接口创建代理类的处理器
//		3.通过代理类和InvocationHandler创建代理对象
//		4.上面已经创建好代理对象了，接着我们就可以使用代理对象了

		// 1. 获取接口对应的代理类
		Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
		// 2. 创建代理类的处理器
		InvocationHandler invocationHandler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("我是InvocationHandler，被调用的方法是：" + method.getName());
				return null;
			}
		};
		// 3. 创建代理实例
		IService proxyService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
		// 4. 调用代理的方法
		proxyService.m1();
	}
}
