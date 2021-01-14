package com.john.xmlconfig;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/11
 */
public class MethodReplace  implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("方法已经被替换!");
		return null;
	}
}
