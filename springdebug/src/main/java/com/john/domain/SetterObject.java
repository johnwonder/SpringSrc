package com.john.domain;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class SetterObject {

	private MovieFinder movieFinder;

	// a setter method so that the Spring container can inject a MovieFinder
	public void setMovieFinder(MovieFinder movieFinder) {
		System.out.println("setter method"+ movieFinder);
		this.movieFinder = movieFinder;
	}
}
