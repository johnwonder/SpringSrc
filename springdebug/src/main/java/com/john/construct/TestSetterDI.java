package com.john.construct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/20
 */
public class TestSetterDI {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-di.xml");
		SimpleMovieLister movielistener=(SimpleMovieLister)context.getBean("movielistener");
		System.out.print(movielistener);


	}
}
