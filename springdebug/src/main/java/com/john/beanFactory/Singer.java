package com.john.beanFactory;

public class Singer {

	private String gender;
	private String country;
	private String name;

	public Singer() {

	}

	public Singer(String country,String gender) {
		this.country = country;
		this.gender =gender;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getGender() {
		return gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// 省略setter和getter...
	@Override
	public String toString() {
		return "[" + country + " " + gender + " " + name + "]";
	}
}