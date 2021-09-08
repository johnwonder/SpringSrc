package com.john.javabase.function;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/30
 */
public class JavaRedcuceDemo {

	///https://blog.csdn.net/icarusliu/article/details/79504602
	//https://www.cnblogs.com/gaohanghang/p/12390233.html
	public static void main(String[] args) {

		//OpenFeign 里的 Capability 接口包含 reduce操作的 静态方法
		Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
		Predicate<String> predicate = t -> t.contains("a");
		 s1.reduce(new ArrayList<String>(), new BiFunction<ArrayList<String>, String, ArrayList<String>>() {
					@Override
					public ArrayList<String> apply(ArrayList<String> strings, String s) {
						if (predicate.test(s)) strings.add(s);
						return strings;
					}
				},
				new BinaryOperator<ArrayList<String>>() {
					@Override
					public ArrayList<String> apply(ArrayList<String> strings, ArrayList<String> strings2) {
						return strings;
					}
				}).stream().forEach(System.out::println);


	}
}
