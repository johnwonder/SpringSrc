package com.john.javabase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/11
 */
public class TestHashMap1 {

	//https://blog.csdn.net/Fighting_mjtao/article/details/81415357
	//https://blog.csdn.net/f641385712/article/details/81880711

	//https://blog.csdn.net/weixin_43689776/article/details/99999126
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("a", "2");
		map.put("a", "3");
		System.out.println(map.size()); //1

		Map<String, String> hashMap = new HashMap<>();
		hashMap.put(new String("a"), "1");
		hashMap.put(new String("a"), "2");
		hashMap.put(new String("a"), "3");
		System.out.println(hashMap.size()); //1

		Map<Integer, String> hashMap2 = new HashMap<>();
		hashMap2.put(new Integer(200), "1");
		hashMap2.put(new Integer(200), "2");
		hashMap2.put(new Integer(200), "3");
		System.out.println(hashMap2.size()); //1

		Map<Demo, String> hashMap3 = new HashMap<>();
		hashMap3.put(new Demo(1), "1");
		hashMap3.put(new Demo(1), "2");
		hashMap3.put(new Demo(1), "3");
		System.out.println(hashMap3.size()); //3
	}

	public static   class Demo{

		private  int num ;

		public Demo(int num) {
			this.num = num;
		}
	}
}
