package com.john.resources;

import com.john.ownspring.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/17
 */
public class ConfigResourcesDemo {

	public static void main(String[] args) {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

//		beanDefinitionReader.loadBeanDefinitions("spring/spring-config*.xml");
		ClassPathResource classPathResource=  new ClassPathResource("spring/spring-config*.xml");
		beanDefinitionReader.loadBeanDefinitions(classPathResource);

		String[] beanNames = beanFactory.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}
}
