package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class BeanAutowireConfigDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-alias.xml");
		SchoolName school=(SchoolName)context.getBean("seniorSchool");

		System.out.println("school name:"+school.getName());

		//context.getBeanFactory().addPropertyEditorRegistrar();

//	    String[] aliases =	context.getAliases("school");
//
//		System.out.println(String.join(",", aliases));
//		for (String alias : aliases) {
//
//			System.out.println(alias);
//		}
	}

}
