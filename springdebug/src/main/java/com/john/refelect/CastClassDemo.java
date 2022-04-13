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

		//System.out.println(((String) p).charAt(0));

		List<Integer> hashCodes = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			Person person = new Person();

			if(hashCodes.contains(person.hashCode())){
				System.out.println(person.hashCode());
			}
			else
			hashCodes.add(person.hashCode());

		}

	}
}
