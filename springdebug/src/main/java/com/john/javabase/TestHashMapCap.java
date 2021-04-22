package com.john.javabase;

import java.util.HashMap;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/2
 */
public class TestHashMapCap {

	public static void main(String[] args) {

		HashMap<Integer,String> capMap = new HashMap<>(5);


		for (int i = 0; i < 10; i++) {
			capMap.put(i,String.valueOf(i));
		}

	}
}
