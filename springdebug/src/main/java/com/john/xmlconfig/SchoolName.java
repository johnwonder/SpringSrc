package com.john.xmlconfig;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class SchoolName {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SchoolName childSchool;

	public SchoolName getChildSchool() {
		return childSchool;
	}

	public void setChildSchool(SchoolName childSchool) {
		this.childSchool = childSchool;
	}

	@Override
	public String toString() {
		return "SchoolName{" +
				"name='" + name + '\'' +
				'}';
	}
}
