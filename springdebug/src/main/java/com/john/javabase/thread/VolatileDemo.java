package com.john.javabase.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/10/25
 */
public class VolatileDemo {

	public static volatile Integer t =0;
	static  ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		System.out.println("g()V");
		System.out.println("线程开启");
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {

				lock.lock();

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				t = t +1;

				lock.unlock();
			}).start();
		}

		System.out.println("线程执行结束");
		System.out.println(t);
	}
}
