package com.john.construct;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class SimpleMovieLister {

	private MovieFinder movieFinder;

	// a constructor so that the Spring container can inject a MovieFinder
//	public SimpleMovieLister(MovieFinder movieFinder) {
//		this.movieFinder = movieFinder;
//	}

	// a setter method so that the Spring container can inject a MovieFinder
	public void setMovieFinder(MovieFinder movieFinder) {
		System.out.println(movieFinder);
		this.movieFinder = movieFinder;
	}
}
