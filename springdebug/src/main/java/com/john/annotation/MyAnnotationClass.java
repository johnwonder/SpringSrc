package com.john.annotation;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/10
 */
public class MyAnnotationClass {

	@MyAliasAnnotation(location = "这是值")
	public static void one(){
	}

//	@MyAliasAnnotation(value = "这是值")
//	public static void one2(){
//	}
}
