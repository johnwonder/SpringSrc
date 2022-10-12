package com.john.javabase.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
public class CollectionsSortDemo {

	public static void main(String[] args) {

		  List<Integer> intList = Arrays.asList(2, 3,1);//Arrays.asList(2, 3,7,8,9,4);//Arrays.asList(2, 3,7,8,9,4);

		System.out.println("before sort:");
		System.out.println(intList);
		System.out.println("=========================");

		System.out.println("after regular sort:");
		//自然升序
		//Collections.sort(intList);
		System.out.println(intList);
		System.out.println("=========================");

		// Find end of run, and reverse range if descending
		//倒序排列
//		if (c.compare(a[runHi++], a[lo]) < 0) { // Descending
//			while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) < 0)
//				runHi++;
//			reverseRange(a, lo, runHi);
//		} else {                              // Ascending
//			while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) >= 0)
//				runHi++;
//		}
		//https://www.runoob.com/design-pattern/strategy-pattern.html
		//策略模式
		//可以加个Comparator
		Collections.sort(intList, (o1, o2) -> {
			// 返回值为int类型，大于0表示正序，小于0表示逆序
			//[3, 2, 1]
			//o1为后一个元素
			//o2为前一个元素
			//小于0  后面一个元素o1排在前面
			return o1-o2;

			// 返回值为int类型，大于0表示正序，小于0表示逆序
			//[1,2,3]
			//return o1-o2;
		});


		//idea提示用list.sort
		//自身有sort方法，传入比较器
//		intList.sort((o1, o2) -> {
//			// 返回值为int类型，大于0表示正序，小于0表示逆序
//			return o2-o1;
//		});

		System.out.println("after custom sort:");
		System.out.println(intList);

		NotCompareble notCompareble = new NotCompareble(1);
		NotCompareble notCompareble1 = new NotCompareble(2);

		List<NotCompareble> comparebles = Arrays.asList(notCompareble,notCompareble1);
		//Collections.sort(comparebles);

		//二分查找 等于-4 没找到
		//如果有两个相同的，无法保证找到哪一个
		List<Integer> binaryList = Arrays.asList(2, 3,1,5,6,1);
		System.out.println(Collections.binarySearch(binaryList, 1));
	}
}
