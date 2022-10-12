package org.wonder.frame.autowire;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/6
 */
public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
