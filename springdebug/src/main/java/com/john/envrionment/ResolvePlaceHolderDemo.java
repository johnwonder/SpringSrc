package com.john.envrionment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class ResolvePlaceHolderDemo {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();//${${java.version}}

		Properties properties = System.getProperties();
		properties.setProperty("john.name","wonder");

		//解析不了会忽略
		System.out.println(applicationContext.getEnvironment().resolvePlaceholders("${john.name}"));

		//如果解析不了会报错
		applicationContext.getEnvironment().resolveRequiredPlaceholders("${${java.version}}");
	}
}
