package com.john.applicationContext;

import com.john.aop.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ObjectProviderBeanFactoryApp
{
    public static void main( String[] args )
    {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-objprovider.xml");

		BeanFactory beanFactory = applicationContext.getBeanFactory();

		System.out.println(beanFactory.getBean(IndexService.class));

		//竟然输出org.springframework.beans.factory.support.DefaultListableBeanFactory$1@2d38eb89
		System.out.println(beanFactory.getBeanProvider(ArticleService.class));

		System.out.println(beanFactory.getBeanProvider(ArticleService.class).getIfAvailable());

		System.out.println(beanFactory.getType("article"));
	}


}
