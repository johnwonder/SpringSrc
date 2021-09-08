package com.john.beanFactory;

import com.john.aop.Person;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class FactoryBeanApp
{
    public static void main( String[] args )
    {

		ClassPathXmlApplicationContext parentContext = new ClassPathXmlApplicationContext("spring-parent.xml");

		SingletonBeanRegistry singletonBeanRegistry = parentContext.getBeanFactory();

		//输出true
		System.out.println(singletonBeanRegistry.containsSingleton("eagerBean"));
	}


}
