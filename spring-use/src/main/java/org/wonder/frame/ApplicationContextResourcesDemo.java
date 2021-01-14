package org.wonder.frame;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/17
 */
public class ApplicationContextResourcesDemo {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext applicationContext=  new ClassPathXmlApplicationContext();

		applicationContext.setConfigLocation("spring/spring-config.xml");
		applicationContext.refresh();
		String[] beanNames = applicationContext.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}
}
