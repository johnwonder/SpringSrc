package com.john.xmlconfig;

import com.john.aop.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class BeanPropertyDemo {

	public static void main(String[] args) {

		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		Person outerPerson=(Person)context.getBean("outerPerson");


		System.out.println(outerPerson);
	}
}
