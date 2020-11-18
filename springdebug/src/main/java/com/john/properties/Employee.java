package com.john.properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/1
 */
public class Employee {

	private String group;

	private boolean usesDialUp;

	private City city;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isUsesDialUp() {
		return usesDialUp;
	}

	public void setUsesDialUp(boolean usesDialUp) {
		this.usesDialUp = usesDialUp;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"group='" + group + '\'' +
				", usesDialUp=" + usesDialUp +
				", city=" + city +
				'}';
	}
}
