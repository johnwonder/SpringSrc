package com.john.resource;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class MyTagBean {
	private String name;
	private String myPackage;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMyPackage() {
		return myPackage;
	}
	public void setMyPackage(String myPackage) {
		this.myPackage = myPackage;
	}

	@Override
	public String toString() {
		return "MyTagBean{" + "name='" + name + '\'' + ", myPackage='" + myPackage + '\'' + '}';
	}
}
