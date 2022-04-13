package com.john.javabase.queue;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/1/21
 */
public class ConcurrentLinkedQueueDemo {

	public static void main(String[] args) {

		Concurrent concurrent = new Concurrent();

		Concurrent concurrent1 = new Concurrent();

		//true
		System.out.println((concurrent = concurrent1) == concurrent);
		//输出false
		//System.out.println((concurrent == (concurrent = concurrent1)));

		//System.out.println((concurrent == (concurrent = concurrent1)));
	}

	static class Concurrent{


	}
}
