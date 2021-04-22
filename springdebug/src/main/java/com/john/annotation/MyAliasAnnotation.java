package com.john.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
public @interface MyAliasAnnotation {

	@AliasFor(value = "location")
	String value() default "";

	@AliasFor(value = "value")
	String location() default "";
}
