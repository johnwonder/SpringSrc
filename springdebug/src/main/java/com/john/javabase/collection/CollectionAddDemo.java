package com.john.javabase.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Description: 集合添加
 * @Author: johnwonder
 * @Date: 2021/6/2
 */
public class CollectionAddDemo {

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));

		collection.addAll(Arrays.asList(6,7,8));

		System.out.println(collection);

		//最大32
		System.out.println(minRunLength(62));

		//System.out.println(maxRunLength());

	}

	private static int minRunLength(int n) {
		assert n >= 0;
		int r = 0;      // Becomes 1 if any 1 bits are shifted off
		while (n >= 32) {
			r |= (n & 1);
			n >>= 1; //除以2
		}
		return n + r;
	}

	private static int maxRunLength() {
		int n = 0;
		int r = 0;      // Becomes 1 if any 1 bits are shifted off
		while (n < Integer.MAX_VALUE) {
			r |= (n & 1);
			n++;
		}
		return  r;
	}
}
