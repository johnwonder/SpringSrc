package com.john.javabase.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/12
 */
public class ArrayQueueDemo {

	public static void main(String[] args) {

		//jdk8源码解读
		//https://blog.csdn.net/lh513828570/article/details/59560771

		//https://blog.csdn.net/wang7807564/article/details/79636646
		Deque<String> container=new ArrayDeque<String>();

		container.offerLast("john");
		container.offerLast("wonder");

		//后进先出 wonder
		System.out.println(container.pollLast());

		//只有john了
		for (String s : container) {
			System.out.println(s);
		}


		Queue<String> queue = new ArrayDeque<String>();
		queue.add("1");
		queue.add("2");
		queue.add("3");

		//先进先出 输出1
		System.out.println(queue.poll());
		//先进先出 输出2
		System.out.println(queue.poll());
		//先进先出 输出3
		System.out.println(queue.poll());


		int i = -1 & 7;
		//输出7
		System.out.println(i);
	}
}
