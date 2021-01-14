package com.john.event;

import com.john.xmlconfig.SchoolName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/12
 */
public class ReaderEventListenerDemo {

	public static void main(String[] args) {


		MyXmlApplicationContext context=new MyXmlApplicationContext("spring-config-alias.xml");


		SchoolName school=(SchoolName)context.getBean("seniorSchool");

		System.out.println("school name:"+school.getName());
	}
}
