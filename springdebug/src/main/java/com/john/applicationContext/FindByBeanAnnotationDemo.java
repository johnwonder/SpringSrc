package com.john.applicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/26
 */
@Component
public class FindByBeanAnnotationDemo {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(FindByBeanAnnotationDemo.class);

		applicationContext.refresh();

		Map<String, Object> beans=	applicationContext.getBeansWithAnnotation(Configuration.class);

		for (String s : beans.keySet()) {
			System.out.println(s);
		}
	}

	@Configuration
	@Lazy
	public static class ConfigBean {

	}
}
