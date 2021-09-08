package com.john.configurationclass;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/28
 */
public class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
