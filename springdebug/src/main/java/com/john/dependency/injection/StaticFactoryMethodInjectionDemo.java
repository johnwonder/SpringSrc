package com.john.dependency.injection;

import com.john.domain.Car;
import com.john.domain.CarFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class StaticFactoryMethodInjectionDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-static-factory.xml");
		ac.refresh();
		System.out.println(ac.getBean("staticCar"));

	}
}
