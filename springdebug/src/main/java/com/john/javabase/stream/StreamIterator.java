package com.john.javabase.stream;

import java.util.stream.Stream;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2023/3/10
 */
public class StreamIterator {

	public static void main(String[] args) {
		Stream<Integer> intStream = Stream.iterate(0, (x) -> x + 2);
//		intStream.forEach(System.out::println);

		intStream.limit(10).forEach(System.out::println);
	}
}
