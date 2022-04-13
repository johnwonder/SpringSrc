package com.john.ImportBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
public class ImportBeanFactory implements FactoryBean {

	private Class mapper;

	public ImportBeanFactory(Class mapper) {
		this.mapper = mapper;
	}

	public ImportBeanFactory() {
//		this.mapper = mapper;
	}

	@Nullable
	@Override
	public Object getObject() throws Exception {
		Object o = Proxy.newProxyInstance(ImportBeanFactory.class.getClassLoader(), new Class[]{mapper}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName());
				return  null;
			}
		});
		return  o;
	}

	@Nullable
	@Override
	public Class<?> getObjectType() {
		return mapper;
	}
}
