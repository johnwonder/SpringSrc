package com.john.resources;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.UnsupportedEncodingException;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/17
 */
public class ApplicationContextResourcesDemo {

	public static void main(String[] args)  throws UnsupportedEncodingException {

		//https://blog.csdn.net/zhangshk_/article/details/82704010
		//todo 调用 clazz.getResource方法
		ClassPathXmlApplicationContext applicationContext=  new ClassPathXmlApplicationContext("spring-config*.xml");

		//AppClassLoader
		System.out.println(applicationContext.getClassLoader());
		System.out.println(ClassPathXmlApplicationContext.class.getResource("").getPath());

		System.out.println(applicationContext.getClassLoader().getResource("").getPath());

		//System.out.println(System.getProperty("java.class.path"));

//		applicationContext.setConfigLocation("classpath*:spring-config-*.xml");
//		applicationContext.refresh();
		String[] beanNames = applicationContext.getBeanDefinitionNames();

		for (String beanName : beanNames) {

			System.out.println(beanName);
		}

	}

}
