package com.john.javabase.queue;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/7
 */
public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {


		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		for (int i = 0; i < 25; i++) {
			int finalI = i;
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {

					//Thread.currentThread().interrupt();
					System.out.println("runner"+ finalI + "  " + Thread.currentThread().getName());
				}
			});
		}
		//为什么工作线程不会等于5呢 因为offer worker的时候成功了 加入了队列 不用新生成一个线程
		//https://www.jianshu.com/p/4406c2aeff0f
		System.out.println(threadPoolExecutor);


	}
}
