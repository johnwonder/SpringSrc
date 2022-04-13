package com.john.configurationclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/28
 */
@Configuration
@ComponentScan
public class ConfigurationBean implements ConfigurationInterface {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ConfigurationBean.class);
		applicationContext.refresh();

		//@Configuration 会扫描接口中的静态方法
		Person p = applicationContext.getBean(Person.class);
		System.out.println(p);

	}

	private AutowireBean autowireBean;

	@Autowired
	public void autowireBean(AutowireBean autowireBean){

		System.out.println("autowire called");
		this.autowireBean = autowireBean;
	}

	@Bean
	BeanMethodBean methodBean(){

		System.out.println("beanmethod called:"+this.autowireBean);
		return new BeanMethodBean();
	}
}
