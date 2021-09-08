package com.john.javabase.annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/13
 */
public class RepeatableDemo {

	//https://blog.csdn.net/z69183787/article/details/54602994
	public static void main(String[] args) {

		//如果标注两个Role 这边就会报错
		//Role 必须标注@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
		Role role = RepeatAnn.class.getAnnotation(Role.class);
	    System.out.println(role.name());

		Annotation[] annotations = RepeatAnn.class.getAnnotations();
		System.out.println(annotations.length); //1
		Arrays.stream(annotations).forEach(System.out::println);//@com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Roles(value=[@com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Role(name=doctor), @com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Role(name=who)])

		Annotation[] annotations2 = Annotations.class.getAnnotations();
		System.out.println(annotations2.length);//1
		Arrays.stream(annotations2).forEach(System.out::println);//@com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Roles(value=[@com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Role(name=doctor), @com.github.jdk8.ebook.java8_recipes2nd_edition.Chapter2Code$Role(name=who)])

	}
}
