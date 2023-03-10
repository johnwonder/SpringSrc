package com.john.javabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/19
 */
public class ArrayListDemo {

	private String name,age;
	//https://blog.csdn.net/m0_37991005/article/details/111477484
	public static void main(String[] args) {


		int iii = 1 & 2 & 4;
		System.out.println(iii);
		int iiii = 1 | 2 | 4;
		System.out.println(iiii);

		String userId="1,2,3";
		List<String> userList = new ArrayList<>();
		Collections.addAll(userList,userId.split(","));
		System.out.println(userList);

		boolean a = true;
		boolean b = true;
		boolean c = false;

		int i = 0;
		i |= 0;
		System.out.println(i);

		//从右往左
		boolean d=  a || b && c;
		System.out.println(d);

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



		Object[] objs = new Object[] { "1","2"};

		//数组默认有clone
		Object[] cloneObjs = objs.clone();

		//输出false
		System.out.println(cloneObjs == objs);
		for (Object cloneObj : cloneObjs) {
			System.out.println(cloneObj.toString());
		}

	}
}
