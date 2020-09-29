package com.john.constructmode;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/30
 */
public class FactoryMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-factory.xml");
		ac.refresh();
		System.out.println(ac.getBean("staticCar"));
		//System.out.println(ac.getBean("car1"));

	}
}
