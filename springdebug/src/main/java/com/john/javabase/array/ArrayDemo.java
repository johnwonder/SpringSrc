package com.john.javabase.array;

import java.util.Arrays;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/9
 */
public class ArrayDemo {

	public static void main(String[] args) {


		//int[] a = new int[] { 1,2,3,4,5};
		//C-style array declaration of local variable 'a'
		int a[] = new int[] {1,2,3,4,5};

		//[1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(a));

		int[] b = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
		Arrays.sort(b);
		for(int i = 0; i < b.length; i ++) {
			System.out.print(b[i] + " ");
		}
	}
}
