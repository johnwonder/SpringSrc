package com.john.javabase.method;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/18
 */
public class OverrideMethodDemo {

	public static void main(String[] args) {


	}

	void printName(String name,String printer){

	}

	//参数一样，返回值一样是不行的
	String printName(String name){

		return  name;
	}
}
