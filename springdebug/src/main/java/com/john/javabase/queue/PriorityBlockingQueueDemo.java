package com.john.javabase.queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/12/24
 */
public class PriorityBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		PriorityBlockingQueue<Integer> intQueue=  new PriorityBlockingQueue<>();
		Integer first = intQueue.poll(30, TimeUnit.SECONDS);

		System.out.println("第一个元素");
		System.out.println(first);
	}
}
