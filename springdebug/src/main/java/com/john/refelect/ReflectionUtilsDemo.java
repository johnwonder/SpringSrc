package com.john.refelect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/2
 */
public class ReflectionUtilsDemo {

	public static void main(String[] args) {

		ReflectionUtils.doWithLocalMethods(ReflectionUtilsDemo.class, method -> {

			System.out.printf("methodName:%s\n",method.getName());
			//System.out.println(method.getParameterTypes()[0].isArray());

			System.out.println(Collection.class.isAssignableFrom(method.getParameterTypes()[0]) && method.getParameterTypes()[0].isInterface());
		});
	}

	public void setConfigurers(List<String> configurers) {
		if (!CollectionUtils.isEmpty(configurers)) {
			//放到 WebMvcConfigurerComposite 的arrayList中

		}
	}
}
