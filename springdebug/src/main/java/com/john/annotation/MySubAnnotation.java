package com.john.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Inherited
@MyAliasAnnotation
public @interface MySubAnnotation {

	@AliasFor(value="location",annotation=MyAliasAnnotation.class)
	String location() default "";

	//https://www.cnblogs.com/sandyflower/p/10877291.html
	@AliasFor(annotation=MyAliasAnnotation.class)   //缺省指明继承的父注解的中的属性名称，则默认继承父注解中同名的属性名
	String value() default "";
}
