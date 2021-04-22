package com.john.javabase;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: https://blog.csdn.net/wang_8101/article/details/83067860
 * @Author: johnwonder
 * @Date: 2021/4/12
 */
public class LinkedHashMapDemo {

//	LinkedHashMap是HashMap的子类，但是内部还有一个双向链表维护键值对的顺序，每个键值对既位于哈希表中，也位于双向链表中。LinkedHashMap支持两种顺序插入顺序 、 访问顺序
//
//	插入顺序：先添加的在前面，后添加的在后面。修改操作不影响顺序
//	访问顺序：所谓访问指的是get/put操作，对一个键执行get/put操作后，其对应的键值对会移动到链表末尾，所以最末尾的是最近访问的，最开始的是最久没有被访问的，这就是访问顺序。
	public static void main(String[] args) {

//		Map<String, Integer> seqMap = new LinkedHashMap<>();
//		seqMap.put("c",100);
//		seqMap.put("d",200);
//		seqMap.put("a",500);
//		seqMap.put("d",300);
//		for(Map.Entry<String,Integer> entry:seqMap.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}


		Map<String, Integer> accessMap = new LinkedHashMap<>(16,0.75f,true);
		accessMap.put("c",100);
		accessMap.put("d",200);
		accessMap.put("a",500);
		accessMap.get("c");
		accessMap.put("d",300);
		for(Map.Entry<String,Integer> entry:accessMap.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
//		输出
//		a 500
//		c 100
//		d 300
		//最新访问的放在最后面
	}
}
