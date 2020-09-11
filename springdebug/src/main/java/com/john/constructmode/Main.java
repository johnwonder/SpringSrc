package com.john.constructmode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/30
 */
public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(Config.class);

		System.out.println(ac.getBean(Service.class));
	}
}
