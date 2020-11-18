package com.john.javabase.evenListener;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
/**
 * https://blog.csdn.net/jiekou0376/article/details/80278454
 */
public class OpenDoor {

	public static void test() {
		Door door = new Door();
		door.addListener((message) -> {
			System.out.println("====== result: " + message);
		});

		door.send();
	}

	public static void main(String args[]) {
		test();
	}

}
