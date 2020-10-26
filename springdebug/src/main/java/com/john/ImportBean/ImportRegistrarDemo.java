package com.john.ImportBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
public class ImportRegistrarDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(ImportConfig.class);

		applicationContext.refresh();
		applicationContext.getBean(UserService.class).test();
	}
}
