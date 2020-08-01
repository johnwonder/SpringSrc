package com.john.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: cglib 接口的动态代理
 * @Author: johnwonder
 * @Date: 2020/7/9
 * https://blog.csdn.net/starryninglong/article/details/89737419
 */
public class TestInterfaceCGLib implements MethodInterceptor {

	public Object getInstance(Class claxx) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(claxx);
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //https://blog.csdn.net/a837199685/article/details/68930987
		//报错 接口不能调用super.xxx
		//methodProxy.invokeSuper(o,objects);
		return method.getName();
	}
}
