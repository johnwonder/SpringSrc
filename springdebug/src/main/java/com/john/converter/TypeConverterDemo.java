package com.john.converter;

import com.john.xmlconfig.School;
import com.john.xmlconfig.SchoolName;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/13
 */
public class TypeConverterDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-ref.xml");
		ConfigurableEnvironment environment = context.getEnvironment();
		environment.setActiveProfiles("dev");
		context.refresh();

		String school= context.getBean("school1",String.class);

		System.out.println("school name:"+school);


	}
}
