package com.john.javabase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/2
 */
public class CollectionsBinarySearchDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}

		System.out.println("原始的顺序：" + list);

		//洗牌
		Collections.shuffle(list);
		System.out.println("打乱后顺序：" + list);

		//System.out.println("二分查找20：" + Collections.binarySearch(list, 20));
		System.out.println("二分查找2：" + Collections.binarySearch(list, 2));

		//二分查找必须在有序条件下，才能进行，否则会出错。
		//https://blog.csdn.net/weixin_41463193/article/details/88653065
	}
}
