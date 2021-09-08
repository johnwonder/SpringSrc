package com.john.lazy.method;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
@ComponentScan
public class LazyMethodAnnotaionDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(LazyMethodAnnotaionDemo.class);
		ctx.refresh();

		//Bean3 bean3 = ctx.getBean(Bean1.class);

		//https://blog.csdn.net/niugang0920/article/details/115900565
		//需要字段和 类上都标注 @Lazy 注解
		//System.out.println(bean3.getBean4());
	}
}
