package com.john.dependency.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class AutowireInjectionDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-autowire-di.xml");
		ac.refresh();

	    TestBean testBean =	ac.getBean(TestBean.class);

		System.out.println(testBean);
	}
}
