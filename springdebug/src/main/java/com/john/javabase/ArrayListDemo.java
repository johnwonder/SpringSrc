package com.john.javabase;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/19
 */
public class ArrayListDemo {

	//https://blog.csdn.net/m0_37991005/article/details/111477484
	public static void main(String[] args) {

		ArrayList<String> myArrayList =new ArrayList<>();

		myArrayList.add("1");
		myArrayList.add("2");
		myArrayList.add("3");

		myArrayList.add(3,"5");

		Iterator<String> iterator = myArrayList.iterator();
		while (iterator.hasNext()){

			if("1".equals(iterator.next()))
				iterator.remove(); //因为iterator删除的时候修改了expectedModCount++ ，所以不会抛出ConcurrentModificationException
		}
		//使用迭代器删除


		//因为iterator删除的时候修改了expectedModCount++ ，所以不会抛出ConcurrentModificationException
		myArrayList.removeIf("1"::equals);

		System.out.println(myArrayList);
	}
}
