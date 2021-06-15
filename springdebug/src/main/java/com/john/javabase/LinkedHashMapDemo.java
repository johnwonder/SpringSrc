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


		//lru缓存
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(5,0.75F ,true){ //第三个参数设为true时，在被使用时会把被使用的数据放到结尾。
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, String> var){ //该方法原本是默认返回false，会在put之后被执行，重写该方法，在数据多于某个值时，返回true，删除头结点。
				if(this.size() > 5){
					return true;
				}
				return false;
			}


		};
		map.put("aa", "1");
		map.put("bb", "2");
		map.put("cc", "3");
		map.put("dd", "4");
		System.out.println(map);
		map.get("cc");
		System.out.println("=================使用cc==================");
		System.out.println(map);

		map.get("bb");
		System.out.println("=================使用bb===================");
		System.out.println(map);

		map.put("ee","5");
		System.out.println("=================加入ee===================");
		System.out.println(map);

		map.put("ff","6");
		System.out.println("=================加入ff===================");
		System.out.println(map);
	}
}
