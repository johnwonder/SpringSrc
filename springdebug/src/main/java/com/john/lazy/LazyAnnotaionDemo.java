package com.john.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
public class LazyAnnotaionDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx
				= new AnnotationConfigApplicationContext();
		ctx.register(LazyConfigBean.class);
		ctx.refresh();

		//https://blog.csdn.net/niugang0920/article/details/115900565
 	ctx.getBean(Bean1.class);
//		ctx.getBean(Bean2.class);
	}
}
