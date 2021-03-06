package com.john.dependency.injection;

import com.john.domain.SetterObject;
import com.john.domain.SimpleMovieLister;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class ConstructorInjectionDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config-construct-di.xml");
		SimpleMovieLister movielistener=(SimpleMovieLister)context.getBean("movielistener");
		System.out.println(movielistener);

		ListableBeanFactory  beanFactory = context;

		System.out.println(beanFactory.getBeanDefinitionCount());

		String[] beanNames = beanFactory.getBeanDefinitionNames();

		for(String beanName : beanNames){
			System.out.println(beanName);
		}


	}
}
