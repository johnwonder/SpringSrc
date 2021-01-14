package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/8
 */
public class BeanLookupMethodDemo {

	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-config-lookup.xml");

		FruitPlate fp1= (FruitPlate)app.getBean("fruitPlate1");
		FruitPlate fp2 = (FruitPlate)app.getBean("fruitPlate2");

		fp1.getFruit("ss");
		fp2.getFruit("ss");
	}
}
