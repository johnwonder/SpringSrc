package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/8
 */
public class BeanReplaceMethodDemo {

	public static void main(String[] args) {

		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-config-replace.xml");

		app.getBean("testBean",ReplaceMethodBean.class).test();
	}
}
