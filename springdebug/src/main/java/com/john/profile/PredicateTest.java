package com.john.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/1
 */
public class PredicateTest {

	public static void main(String[] args) {


		List<String> moduleAlarms = new ArrayList<>();

		moduleAlarms.stream().filter(s -> s.equals("ss")).findFirst();


		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String s) {

				return s.equals("zhangsan");
			}
		};

		System.out.println(predicate.test("lisi"));
		System.out.println("--- --- --- --- --- ---");
		System.out.println(predicate.test("zhangsan"));
	}
}
