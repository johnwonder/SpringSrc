package com.john.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public class Test {

	//https://www.cnblogs.com/rollenholt/archive/2012/12/27/2835101.html
	public static void main(String[] args) {

		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-innerbean.xml");
		Customer customer=(Customer)context.getBean("customer");

		System.out.println(customer);

	}
}
