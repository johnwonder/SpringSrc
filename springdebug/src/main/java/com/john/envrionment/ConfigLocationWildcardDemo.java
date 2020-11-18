package com.john.envrionment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class ConfigLocationWildcardDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();

//		applicationContext.setConfigLocation("${java.version}.xml");
		//只会查找classes路径下的
//		applicationContext.setConfigLocations("classpath:/spring-config*.xml");

//		applicationContext.setConfigLocations("spring-config*.xml");

		//里面竟然包含了resources目录
		 //System.out.println(System.getProperty("java.class.path"));

		//会查找resources目录下的
//		 applicationContext.setConfigLocations("classpath*:/spring-config-w*.xml");


//		 applicationContext.setConfigLocation("spring-config.xml");

		 applicationContext.setConfigLocation("spring/spring-config*.xml");

		System.out.println(System.getProperty("java.version"));
		applicationContext.refresh();

		 String[] beanNames = applicationContext.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}
}
