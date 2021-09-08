package com.john.annotation;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;

import java.util.function.Consumer;

/**
 * @Description: https://blog.csdn.net/ab411919134/article/details/81782269
 * https://blog.csdn.net/supzhili/article/details/99692075
 * @Author: johnwonder
 * @Date: 2021/4/10
 */
public class SpringAliasForDemo {

	public static void main(String[] args) throws NoSuchMethodException {

		Consumer<MyAliasAnnotation> logic = a -> {

			System.out.println(a.location());
			System.out.println(a.value().equals(a.location()));

			System.out.println(a.value());
			System.out.println("这是值".equals(a.value()));
		};

//		MyAliasAnnotation aliasAnnotation = AnnotationUtils.findAnnotation(MySubAnnotationClass.class.getMethod("one"), MyAliasAnnotation.class);
//		logic.accept(aliasAnnotation);

//		MyAliasAnnotation aliasAnnotation2 = AnnotationUtils.findAnnotation(MyAnnotationClass.class.getMethod("one2"), MyAliasAnnotation.class);
//		logic.accept(aliasAnnotation2);



		//https://www.cnblogs.com/tongongV/p/13863412.html
		MyAliasAnnotation aliasAnnotation1 = AnnotatedElementUtils.findMergedAnnotation(MySubAnnotationClass.class.getMethod("one"), MyAliasAnnotation.class);
		logic.accept(aliasAnnotation1);


		//Java Annotation
		//https://blog.csdn.net/shihlei/article/details/84914268
	}
}
