package com.john.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/1
 */
public class Test {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("datasource.xml");
		jdbcBean jdbc = (jdbcBean) applicationContext.getBean("jdbc");

		System.out.println(jdbc.getUrl());
	}
}
