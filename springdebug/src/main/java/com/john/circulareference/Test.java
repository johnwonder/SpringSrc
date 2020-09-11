package com.john.circulareference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/28
 */
public class Test {

	//快捷键 https://www.cnblogs.com/shix0909/p/12234076.html
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(applicationContext.getBean(X.class));

	}
}
