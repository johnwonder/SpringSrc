package com.john.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/25
 */
@ComponentScan("com.john.autowired")
public class AutowiredDemo {

	@Autowired
	private Task customTask;
	@Autowired
	private Task otherTask;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AutowiredDemo.class);

		applicationContext.refresh();

		AutowiredDemo autowiredDemo = applicationContext.getBean(AutowiredDemo.class);

		System.out.println(autowiredDemo.getCustomTask());
	}

	public Task getCustomTask(){
		return  customTask;
	}
}
