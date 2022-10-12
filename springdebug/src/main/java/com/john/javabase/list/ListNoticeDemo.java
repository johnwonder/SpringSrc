package com.john.javabase.list;

import cn.hutool.core.lang.Assert;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/27
 */
public class ListNoticeDemo {

	public static void main(String[] args) {


		//https://time.geekbang.org/column/article/216778
		//其原因是，只能是把 int 装箱为 Integer，不可能把 int 数组装箱为 Integer 数组。
		// 我们知道，Arrays.asList 方法传入的是一个泛型 T 类型可变参数，最终 int 数组整体作为了一个对象成为了泛型类型 T
		//修复方式有两种，如果使用 Java8 以上版本可以使用 Arrays.stream 方法来转换，
		// 否则可以把 int 数组声明为包装类型 Integer 数组
		int[] arr = {1, 2, 3};
		List list = Arrays.asList(arr);
	    System.out.format("list:%s size:%s class:%s \n", list, list.size(), list.get(0).getClass());


		int[] arr1 = {1, 2, 3};
		List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
		System.out.format("list:%s size:%s class:%s \n", list1, list1.size(), list1.get(0).getClass());

		Integer[] arr2 = {1, 2, 3};
		List list2 = Arrays.asList(arr2);
		System.out.format("list:%s size:%s class:%s \n", list2, list2.size(), list2.get(0).getClass());



		List<Integer> listsub = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
//		List<Integer> subList = listsub.subList(1, 4);

		//方式一：
		//List<Integer> subList = new ArrayList<>(listsub.subList(1, 4));

		//方式二：
		//skip参数从第一个开始
		List<Integer> subList = listsub.stream().skip(1).limit(3).collect(Collectors.toList());
		System.out.println(subList);
		subList.remove(1); //影响了原来的list
		System.out.println(listsub);
		listsub.add(0);
		try {
			subList.forEach(System.out::println);
		} catch (Exception ex) {
			ex.printStackTrace();
		}



		int elementCount = 1000000;
		int loopCount = 1000;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("listSearch");
		Object list3 = listSearch(elementCount, loopCount);
		System.out.println(ObjectSizeCalculator.getObjectSize(list3));
		stopWatch.stop();
		stopWatch.start("mapSearch");
		Object map = mapSearch(elementCount, loopCount);
		stopWatch.stop();
		System.out.println(ObjectSizeCalculator.getObjectSize(map));
		System.out.println(stopWatch.prettyPrint());
		//20861992
		//72388672
		//StopWatch '': running time (millis) = 3786
		//-----------------------------------------
		//ms     %     Task name
		//-----------------------------------------
		//03650  096%  listSearch
		//00136  004%  mapSearch
	}


	private static Object listSearch(int elementCount, int loopCount) {
		List<Order> list = IntStream.rangeClosed(1, elementCount).mapToObj(Order::new).collect(Collectors.toList());
		IntStream.rangeClosed(1, loopCount).forEach(i -> {
			int search = ThreadLocalRandom.current().nextInt(elementCount);
			Order result = list.stream().filter(order -> order.getOrderId() == search).findFirst().orElse(null);
			Assert.isTrue((result != null && result.getOrderId() == search));
		});
		return list;
	}



	private static Object mapSearch(int elementCount, int loopCount) {
		Map<Integer, Order> map = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toMap(Function.identity(), Order::new));
		IntStream.rangeClosed(1, loopCount).forEach(i -> {
			int search = ThreadLocalRandom.current().nextInt(elementCount);
			Order result = map.get(search);
			Assert.isTrue((result != null && result.getOrderId() == search));
		});
		return map;
	}



	static class Order {

		public Order(int orderId) {
			this.orderId = orderId;
		}

		private int orderId;

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
	}
}
