package com.john.properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/1
 */
public class City {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City{" +
				"name='" + name + '\'' +
				'}';
	}
}
