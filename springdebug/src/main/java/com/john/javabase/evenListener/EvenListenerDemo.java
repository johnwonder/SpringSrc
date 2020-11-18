package com.john.javabase.evenListener;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class EvenListenerDemo {

	public static void main(String[] args) {

		//https://www.cnblogs.com/qinwangchen/p/5445413.html
		Map<Integer, String> map = new HashMap<Integer, String>();
		MyListener mylistener = new MyListener(map);
	}
}

