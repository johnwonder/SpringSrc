package com.john.domain;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class SimpleMovieLister implements BeanNameAware{

	private MovieFinder finder;

//	public SimpleMovieLister() {
//		System.out.println("执行没构造参数的");
//
//	}
	 //a constructor so that the Spring container can inject a MovieFinder
	public SimpleMovieLister(MovieFinder movieFinder, ApplicationContext applicationContext) {
		System.out.println("construct"+ movieFinder);
		System.out.println("applicationContext: "+ applicationContext);

		this.finder = movieFinder;
	}

	// a setter method so that the Spring container can inject a MovieFinder
	public void setMoviefinder(MovieFinder movieFinder) {
		System.out.println("setter method"+ movieFinder);
		this.finder = movieFinder;
	}

	@Override
	public void setBeanName(String name) {

		System.out.println("setBeanName: " +name);
	}
}
