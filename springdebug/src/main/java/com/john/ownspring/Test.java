package com.john.ownspring;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class Test {

	public static void main(String[] args) {

		ApplicationContext myAppContext = new ClassPathXmlApplicationContext("");

		myAppContext.getBean("bean1");
	}
}
