package com.john.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/16
 */
@ComponentScan(basePackages = "org.springframework")
public class DefaultPackageBootstrap {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DefaultPackageBootstrap.class);

		Stream.of(context.getBeanDefinitionNames()).map( name -> "\t" +name)
				.forEach(System.out::println);

		context.close();
	}
}
