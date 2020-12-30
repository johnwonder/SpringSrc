package com.john.propertyEditor;

import com.john.properties.jdbcBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Type;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/29
 */
public class Test {

	//https://blog.csdn.net/shenchaohao12321/article/details/80295371
	//https://blog.csdn.net/xinyoulin/article/details/52315810 spring4.0的配置
	public static void main(String[] args) {

		MyEnum ss = MyEnum.Bei;
		System.out.println(((Type)ss.getClass()).toString());


		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config-pe.xml");
		Boss boss = (Boss) applicationContext.getBean("boss");

		//System.out.println(boss.getCar().brand + boss.getCar().getPrice());
	}

	public  enum  MyEnum{

		Bei,
		Shanghai
	}
}
