package org.wonder.frame.autowire.pd;

import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/9
 */
public class Person {

	private List<PersonName> name;

	public List<PersonName> getName() {
		return name;
	}

	public void setName(List<PersonName> name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name=" + name +
				'}';
	}
}
