package com.john.propertyEditor;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/29
 */
public class Boss {
	private String name;
	private Car[] car;
	//省略get/setter


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car[] getCar() {
		return car;
	}

	public void setCar(Car[] car) {
		this.car = car;
	}
}
