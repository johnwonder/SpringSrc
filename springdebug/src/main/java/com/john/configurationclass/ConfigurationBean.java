package com.john.configurationclass;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/28
 */
@Configuration
public class ConfigurationBean implements ConfigurationInterface {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ConfigurationBean.class);
		applicationContext.refresh();

		//@Configuration 会扫描接口中的静态方法
		Person p = applicationContext.getBean(Person.class);
		System.out.println(p);

	}
}
