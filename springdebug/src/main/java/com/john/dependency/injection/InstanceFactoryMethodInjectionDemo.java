package com.john.dependency.injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class InstanceFactoryMethodInjectionDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-instance-factory.xml");
		ac.refresh();
		//System.out.println(ac.getBean("instanceCar"));
		//System.out.println(ac.getBean("car1"));

		//System.out.println(ac.getBean("&carFactory"));


	}
}
