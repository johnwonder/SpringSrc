package com.john.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class BeanAliasSameTypeDemo {

	public static void main( String[] args ) {


		//https://vladmihalcea.com/why-i-like-spring-bean-aliasing/
		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-alias-same.xml");

		//会先从别名集合中去查找 所以即使别名配置和bean id一样 找到的还是别名的那个
		SchoolName school=(SchoolName)context.getBean("school");

		System.out.println(school);
	}

}
