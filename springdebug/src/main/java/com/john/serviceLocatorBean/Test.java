package com.john.serviceLocatorBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public class Test {

	//https://yanbin.blog/spring-servicelocator-pattern/#more-9323
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

	   Parser parser = ac.getBean(ParserFactory.class).getParser("j");
		System.out.println(parser.parse("ccc"));

	}
}
