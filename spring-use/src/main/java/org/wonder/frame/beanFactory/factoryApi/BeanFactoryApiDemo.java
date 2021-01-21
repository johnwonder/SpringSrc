package org.wonder.frame.beanFactory.factoryApi;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.wonder.frame.objectProvider.UserObject;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/16
 */
public class BeanFactoryApiDemo {

	public static void main(String[] args) {

		BeanFactory beanFactory=  new ClassPathXmlApplicationContext("spring/spring-config.xml");

		//虽然是延迟初始化的 但是也返回true
		System.out.println(beanFactory.containsBean("user1"));

		System.out.println(beanFactory.isPrototype("user1"));

		System.out.println(beanFactory.getType("user1"));

		System.out.println("is Singleton:" +beanFactory.isSingleton("user1"));
	}
}
