package com.john.javabase.str;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/5/18
 */
public class StringJoinerDemo {

	public static void main(String[] args) {

		StringJoiner sj = new StringJoiner(",");
		IntStream.range(1,10).forEach(i->sj.add(i+""));

		System.out.println(sj.toString());

		sj.add("john");

		System.out.println(sj.toString());


	}
}
