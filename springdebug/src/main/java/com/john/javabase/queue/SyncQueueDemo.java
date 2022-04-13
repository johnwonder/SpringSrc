package com.john.javabase.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/7
 */
public class SyncQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

		Thread putThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("put thread start");
				try {
					queue.put(1);
				} catch (InterruptedException e) {
				}
				System.out.println("put thread end");
			}
		});

//		Thread takeThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("take thread start");
//				try {
//					System.out.println("take from putThread: " + queue.take());
//				} catch (InterruptedException e) {
//				}
//				System.out.println("take thread end");
//			}
//		});

		putThread.start();
		Thread.sleep(1000);
		//takeThread.start();

		//原文链接：https://blog.csdn.net/yanyan19880509/article/details/52562039
	}
}
