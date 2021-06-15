package com.john.primary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @Description: @Primary注解用于@Bean注解的方法
 * @Author: johnwonder
 * @Date: 2021/6/12
 */
public class PrimaryAnnotationMethodDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(PrimaryAnnotationMethodDemo.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(SameTypeBean.class));
	}

	@Bean
	@Primary
	SameTypeBean sameTypeBean(){
		return new SameTypeBean()
				;
	}

	@Bean
	SameTypeBean anotherSameTypeBean(){
		return new SameTypeBean();
	}


	static class SameTypeBean {

	}
}


