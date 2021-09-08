package com.john.javabase.queue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/15
 */
public class DelayQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		//在调用await()方法前线程必须获得重入锁（第17行代码），
		// 调用await()方法后线程会释放当前占用的锁
		//https://blog.csdn.net/qq_36864672/article/details/77531778

		//https://www.cnblogs.com/hhan/p/10678466.html
		Item item1 = new Item("item1", 5, TimeUnit.SECONDS);
		Item item2 = new Item("item2",10, TimeUnit.SECONDS);
		Item item3 = new Item("item3",15, TimeUnit.SECONDS);
		DelayQueue<Item> queue = new DelayQueue<>();
		queue.put(item1);
		queue.put(item2);
		queue.put(item3);
		System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		for (int i = 0; i < 3; i++) {
			Item take = queue.take();
			System.out.format("name:{%s}, time:{%s}\n",take.name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		}
	}
}

class Item implements Delayed {
	/* 触发时间*/
	private long time;
	String name;

	public Item(String name, long time, TimeUnit unit) {
		this.name = name;
		this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return time - System.currentTimeMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		Item item = (Item) o;
		long diff = this.time - item.time;
		if (diff <= 0) {// 改成>=会造成问题
			return -1;
		}else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "Item{" +
				"time=" + time +
				", name='" + name + '\'' +
				'}';
	}
}
