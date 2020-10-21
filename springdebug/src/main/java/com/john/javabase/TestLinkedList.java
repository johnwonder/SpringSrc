package com.john.javabase;

import java.util.LinkedList;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/20
 */
public class TestLinkedList {

	public static void main(String[] args) {

		LinkedList<String> orderList = new LinkedList<>();

		orderList.push("ss");
		orderList.push("ee");

		System.out.println(orderList.get(0));//ee
		System.out.println(orderList.get(1));//ss
	}
}
