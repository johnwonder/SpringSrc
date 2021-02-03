package org.wonder.frame.utilsNamespace;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/3
 */
public class UtilsConstant {

	public static final String hwStatic = "hello static constant";

	public static void main(String[] args) {
		BeanFactory beanFactory=  new ClassPathXmlApplicationContext("spring/spring-utils.xml");

		//虽然是延迟初始化的 但是也返回true
		System.out.println(beanFactory.getBean("hwConstant"));

	}
}
