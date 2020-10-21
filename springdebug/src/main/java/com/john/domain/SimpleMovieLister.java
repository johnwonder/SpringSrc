package com.john.domain;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class SimpleMovieLister {

	private MovieFinder finder;

//	public SimpleMovieLister() {
//		System.out.println("执行没构造参数的");
//
//	}
	 //a constructor so that the Spring container can inject a MovieFinder
	public SimpleMovieLister(MovieFinder movieFinder) {
		System.out.println("construct"+ movieFinder);

		this.finder = movieFinder;
	}

	// a setter method so that the Spring container can inject a MovieFinder
	public void setMoviefinder(MovieFinder movieFinder) {
		System.out.println("setter method"+ movieFinder);
		this.finder = movieFinder;
	}
}
