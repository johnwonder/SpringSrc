package org.wonder.frame.beandefinition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/11
 */
public class BeanDefinitionDemo {

	public static void main(String[] args) {


		BeanFactory beanFactory=  new ClassPathXmlApplicationContext("spring/spring-config-bean.xml");

		System.out.println(beanFactory.getBean("childBean"));
	}
}
