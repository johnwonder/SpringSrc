package com.john.envrionment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class ConfigLocationsDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();//${${java.version}}

		 applicationContext.setConfigLocations("spring-config.xml","spring-config-instance-factory.xml");

		 applicationContext.refresh();

		 String[] beanNames = applicationContext.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}
}
