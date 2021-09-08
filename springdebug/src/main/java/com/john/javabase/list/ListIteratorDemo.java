package com.john.javabase.list;

import org.springframework.core.env.MapPropertySource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/5
 */
public class ListIteratorDemo {

	//https://blog.csdn.net/bbc955625132551/article/details/77962587/
	public static void main(String[] args) {

		Map<String, Object> configurations = new HashMap<>();

		configurations.put("1",11);
		configurations.put("2",22);

		Iterator var9 =  configurations.entrySet().iterator();

		System.out.println(iteratorResult(var9));
	}

	private  static  String iteratorResult(Iterator iterator){
		Map.Entry entry;
		do {
			if (!iterator.hasNext()) {
				return  "22";
			}

			entry = (Map.Entry)iterator.next();
		} while(!((String)entry.getKey()).startsWith("2"));

		return  "3";
	}
}
