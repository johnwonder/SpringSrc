package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class BeanProfileDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-profile.xml");
		ConfigurableEnvironment environment = context.getEnvironment();
		environment.setActiveProfiles("dev");
		context.refresh();

		SchoolName school=(SchoolName)context.getBean("school1");

		System.out.println("school name:"+school.getName());


//	    String[] aliases =	context.getAliases("school");
//
//		System.out.println(String.join(",", aliases));
//		for (String alias : aliases) {
//
//			System.out.println(alias);
//		}
	}

}
