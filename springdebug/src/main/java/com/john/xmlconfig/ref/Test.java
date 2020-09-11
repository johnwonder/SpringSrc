package com.john.xmlconfig.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class Test {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-ref.xml");
		School school=(School)context.getBean("lschool");
		System.out.print("student name:"+school.getStudents().getName()+"teacher name :"+school.getTeachers().getName());


	}

}
