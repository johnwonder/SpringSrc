package com.john.javabase.collection;

import org.springframework.util.Assert;

import java.util.*;

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

		Set<Class<?>> annotatedClasses = new LinkedHashSet<>();
		//annotatedClasses.add(CollectionAddDemo.class);
		boolean c = Collections.addAll(annotatedClasses,CollectionAddDemo.class,CollectionAddDemo.class);
		for (Class<?> annotatedClass : annotatedClasses) {
			System.out.println(annotatedClass);
		}

		boolean b = false;
		//boolean 类型 或运算
		b |= c;
		System.out.println(b);
	}

	private static void register(Set<Class<?>> classes,Class<?>... annotatedClasses) {
		//Assert.notEmpty(annotatedClasses, "At least one annotated class must be specified");
		Collections.addAll(classes, annotatedClasses);
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
