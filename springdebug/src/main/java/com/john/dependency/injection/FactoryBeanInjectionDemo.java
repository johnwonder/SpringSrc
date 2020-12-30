package com.john.dependency.injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class FactoryBeanInjectionDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext();
		ac.setConfigLocations("spring-config-locatorfactory.xml");
		ac.refresh();
		//System.out.println(ac.getBean("car"));

		//System.out.println(ac.getBean("&car"));

		String[] aliases =  ac.getAliases("&car");

		for (String alias : aliases) {

			System.out.println(alias);
		}
	}
}
