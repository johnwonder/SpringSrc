package com.john.refelect;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/2
 */
public class Person implements  IPerson{

	@Override
	public void call() {
		System.out.println("call");
	}
}
