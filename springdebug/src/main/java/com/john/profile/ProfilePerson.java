package com.john.profile;

/**
 * @Description: Profile测试
 * @Author: johnwonder
 * @Date: 2020/7/7
 */
public class ProfilePerson {

	private String name;

	private int age;

	public ProfilePerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		String str = "name:" +name+ ";age:" +age;
		//System.out.println(str);
		return str;

	}
}
