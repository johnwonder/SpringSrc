package com.john.xmlconfig;

import com.john.aop.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class BeanImportDemo {

	public static void main(String[] args) {

		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-import.xml");
		Person outerPerson=(Person)context.getBean("outerPerson");


		System.out.println(outerPerson);
	}
}
