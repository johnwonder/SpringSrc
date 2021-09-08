package com.john.javabase.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/5
 */
public class ReentrantLockDemo {

	public static void main(String[] args) {


		//重点看 ReentrantLock
		//https://mp.weixin.qq.com/s/AGOC71tdvTX5cevrfvTOuA

		//https://baijiahao.baidu.com/s?id=1648624077736116382&wfr=spider&for=pc
		//https://www.cnblogs.com/takumicx/p/9338983.html

		//https://blog.csdn.net/w8y56f/article/details/89554060
		//什么是 “可重入”，可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁。
		//CopyOnWriteArrayList 里用了 ReentrantLock

		Lock lock = new ReentrantLock();

		lock.unlock();
		lock.unlock();
		lock.unlock();
		lock.unlock();

		//https://mp.weixin.qq.com/s/5t_YK4kKOtCaKrYudHuPuA
		//考虑到每次CopyOnWrite容器进行修改的时候都需要加锁和对容器进行拷贝，写的性能开销较大，所以更适合使用在读操作远远大于写操作的场景里，比如缓存、搜索引擎对某些关键词过滤使用的黑名单等。发生修改时候做copy，新老版本分离，保证读的高性能，适用于以读为主的情况。
		//因为CopyOnWrite容器只能保证最终一致性，所以不适用于对数据实时性要求较高的场景中，因为一个线程修改了数据，其他线程并不一定能够马上读取到新的数据。
	}
}
