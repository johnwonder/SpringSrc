package com.john.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/19
 */
@ComponentScan("com.john.factorybean")
public class FactoryBeanDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(FactoryBeanDemo.class);
		applicationContext.refresh();

		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
	}
}
