package com.john.javabase;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/20
 */
public class TestLinkedList {

	public static void main(String[] args) {

		LinkedList<String> orderList = new LinkedList<>();

		orderList.push("ss");//添加到第一个
		orderList.push("ee");//ee变为第一个

		orderList.add("dd");//添加到最后一个

//		System.out.println(orderList.get(0));//ee
//		System.out.println(orderList.get(1));//ss

//		for (String s : orderList) {
//			System.out.println(s);
//		}

		//使用orderList对象删除
//		Iterator<String> iterator=orderList.iterator();//实例化迭代器
//		while(iterator.hasNext()){
//			String str=iterator.next();//读取当前集合数据元素
//			if("ss".equals(str)){ //删除第二个元素时会 终止遍历 因为nextIndex为2 但是size等于2了
//				orderList.remove(str); //终止了 所以不会抛出ConcurrentModificationException
//			}else{
//				System.out.println( str+" ");
//			}
//		}

//		Iterator<String> iterator=orderList.iterator();//实例化迭代器
//		while(iterator.hasNext()){
//			String str=iterator.next();//读取当前集合数据元素
//			if("ee".equals(str)){
//				orderList.remove(str);//删除第一个元素时会 抛出ConcurrentModificationException
//			}else{
//				System.out.println( str+" ");
//			}
//		}



		//https://blog.csdn.net/qq_30310607/article/details/82347807
		//使用迭代器删除
		Iterator<String> iterator = orderList.iterator();

		while (iterator.hasNext()){

			if("ee".equals(iterator.next()))
				iterator.remove(); //因为iterator删除的时候修改了expectedModCount++ ，所以不会抛出ConcurrentModificationException
		}

		System.out.println(orderList);
	}
}
