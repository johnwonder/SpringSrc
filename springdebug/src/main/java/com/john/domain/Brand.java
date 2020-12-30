package com.john.domain;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class Brand {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Brand{" +
				"name='" + name + '\'' +
				'}';
	}
}
