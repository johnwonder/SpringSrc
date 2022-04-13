package com.john.annotation;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/16
 */
public class MySubAnnotationClass {

	//location 和value 只能设置的一样 ，不然报错
	@MySubAnnotation(location = "这是值",value = "这是值")
	public static void one(){
	}
}
