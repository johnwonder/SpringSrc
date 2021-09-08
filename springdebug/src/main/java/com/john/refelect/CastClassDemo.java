package com.john.refelect;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/2
 */
public class CastClassDemo {

	public static void main(String[] args) {

		//https://stackoverflow.com/questions/1504633/what-is-the-point-of-invokeinterface
		Object p =new Person();

		System.out.println(((String) p).charAt(0));


	}
}
