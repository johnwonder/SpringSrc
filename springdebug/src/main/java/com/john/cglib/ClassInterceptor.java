package com.john.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: cglib 类的动态代理
 * @Author: johnwonder
 * @Date: 2020/7/9
 */
public class ClassInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("I am intercept begin");
//Note: 此处一定要使用proxy的invokeSuper方法来调用目标类的方法
		proxy.invokeSuper(obj, args);
		System.out.println("I am intercept end");
		return null;
	}
}

