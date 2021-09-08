package com.john.autowire.beanmethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/24
 */
@Configuration
public class ConfigClassAutowireDemo {

	public static void main(String[] args) {

			AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
			applicationContext.register(ConfigClassAutowireDemo.class);
			applicationContext.refresh();

			Bean1 bean1 = applicationContext.getBean(Bean1.class);
			System.out.println(bean1);
	}

	@Bean
	Bean1 getBean1(){
		Bean1 bean1 =  new Bean1();
		System.out.println(bean1);
		return  bean1;
	}

	@Bean
	Bean2 getBean2(Bean1 bean1){
		System.out.println(bean1);
		return  new Bean2();
	}
}
