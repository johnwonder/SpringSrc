package com.john.xmlconfig.entity;

import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/1/25
 */
public class Person {

	private List<String[]> books;

	public List<String[]> getBooks() {
		return books;
	}

	public void setBooks(List<String[]> books) {
		this.books = books;
	}
}
