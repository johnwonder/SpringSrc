package com.john.javabase.reflect;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/2/11
 */

public class SubClass implements SuperClass<String> {
	public String method(String param) {
		return param;
	}
}
