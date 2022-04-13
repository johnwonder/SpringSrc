package com.john.ImportBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
public class ImportRegistrarDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.john.ImportBean");

		//ImportConfig 变成 AnnotatedGenericBeanDefinition
		//applicationContext.register(ImportConfig.class);

		//不刷新还会报错。。
		//applicationContext.refresh();

		//applicationContext.getBean(UserService.class).test();

		System.out.println(applicationContext.getBean(ImportBeanFactory.class));

	}
}
