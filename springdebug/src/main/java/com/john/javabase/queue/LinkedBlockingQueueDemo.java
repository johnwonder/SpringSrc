package com.john.javabase.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: https://www.cnblogs.com/duodushuduokanbao/p/9556555.html
 * @Author: johnwonder
 * @Date: 2022/1/20
 */
public class LinkedBlockingQueueDemo {

	public static void main(String[] args) {


		try{
			BlockingQueue queue = new LinkedBlockingQueue(5);

			ExecutorService executor = Executors.newFixedThreadPool(5);
			Produer producer = new Produer(queue);
			for(int i=0;i<3;i++){
				executor.execute(producer);
			}
			executor.execute(new Consumer(queue));

			executor.shutdown();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	static class Produer implements  Runnable{

		private BlockingQueue queue;
		private int nums = 20;  //循环次数

		//标记数据编号
		private static volatile AtomicInteger count = new AtomicInteger();
		private boolean isRunning = true;
		public Produer(){}

		public Produer(BlockingQueue queue){
			this.queue = queue;
		}

		public void run() {
			String data = null;
			try{
				System.out.println("开始生产数据");
				System.out.println("-----------------------");

				while(nums>0){
					nums--;
					System.out.println(Thread.currentThread().getId()+ " :生产者开始生产："+count.decrementAndGet());

					Thread.sleep(500);

					int  producedata =count.getAndIncrement();
					queue.put(producedata);
					System.out.println(Thread.currentThread().getId()+ " :生产者生产了一个数据:"+producedata+";"+System.currentTimeMillis());
				}
			}catch(Exception e){
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}finally{
				System.out.println("生产者线程退出！");
			}
		}
	}

	static class Consumer implements Runnable{

		private BlockingQueue queue;
		private int nums = 20;
		private boolean isRunning = true;

		public Consumer(){}

		public Consumer(BlockingQueue queue){
			this.queue = queue;
		}

		public void run() {

			System.out.println("消费者开始消费");
			System.out.println("-------------------------");

			while(nums>0){
				nums--;
				System.out.println("消费者继续消费");
				try{
					while(isRunning){
						int data = (Integer)queue.take();
						Thread.sleep(500);
						System.out.println("消费者消费的数据是" + data);
					}

				}catch(Exception e){
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}finally {
					System.out.println("消费者线程退出!");
				}

			}
		}
	}
}
