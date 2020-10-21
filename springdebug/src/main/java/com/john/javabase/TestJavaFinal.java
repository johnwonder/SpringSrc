package com.john.javabase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/21
 */
public class TestJavaFinal {

	public static void main(String[] args) {

		//JavaFinalClass.name = "wonder";  //error
		//JavaFinalClass.finalMap = new HashMap<>(); //error

		JavaFinalClass.finalMap.put("john","wonder"); //right

		System.out.println(JavaFinalClass.finalMap);
	}
}
