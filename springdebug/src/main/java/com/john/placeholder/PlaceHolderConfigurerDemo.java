package com.john.placeholder;

import com.john.properties.jdbcBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/13
 */
public class PlaceHolderConfigurerDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-placeholder.xml");

	    jdbcBean jdbcBean = xmlApplicationContext.getBean(jdbcBean.class);

		System.out.println(jdbcBean.getUrl());

	}
}
