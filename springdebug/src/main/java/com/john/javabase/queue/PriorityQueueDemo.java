package com.john.javabase.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/13
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {


		//https://blog.csdn.net/prestigeding/category_6431121.html
		//https://blog.csdn.net/prestigeding/article/details/53524958
		Queue<Integer> pq = new PriorityQueue<>();
		pq.offer(10);
		pq.add(22);
		pq.addAll(Arrays.asList(new Integer[]{
				11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13 }));
		while(pq.peek()!=null){
			System.out.println(pq.poll() + " ");
		}
	}
}
