package com.john.xmlconfig;

import com.john.xmlconfig.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class BeanConvertPropertyDemo {

	public static void main(String[] args) {

		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-convert-config.xml");
		Person outerPerson=(Person)context.getBean("person");


		System.out.println(outerPerson.getBooks());
	}
}
