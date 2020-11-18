package com.john.envrionment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class ConfigResourcesDemo {

	public static void main(String[] args) {

		//项
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml",ClassPathXmlApplicationContext.class);//${${java.version}}

		 String[] beanNames = applicationContext.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}
}
