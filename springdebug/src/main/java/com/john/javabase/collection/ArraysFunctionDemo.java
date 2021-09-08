package com.john.javabase.collection;

import java.util.Arrays;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/5
 */
public class ArraysFunctionDemo {

	public static void main(String[] args) {

		for (String arg : args) {

			System.out.println(arg);
		}
		//https://blog.csdn.net/qq_25131363/article/details/85001414
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = Arrays.copyOf(arr1, 5);
		int[] arr3 = Arrays.copyOf(arr1, 10);
		for(int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
		for(int i = 0; i < arr3.length; i++)
			System.out.print(arr3[i] + " ");

		System.out.println("-------");
		String[] copy = new String[10];
		String[] strArr = {"1", "2", "3", "4", "5"};
		System.arraycopy(strArr, 0, copy, 0,
				Math.min(5, 10));

		//默认值为null
		for(int i = 0; i < copy.length; i++)
			System.out.print(copy[i] + " ");
	}
}
