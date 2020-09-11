package com.john.innerbean;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public class Person
{
	private String name;
	private String address;
	private int age;

	//getter and setter methods


	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", age=" + age + ", name=" + name + "]";
	}
}
