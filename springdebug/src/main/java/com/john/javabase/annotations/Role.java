package com.john.javabase.annotations;

import java.lang.annotation.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(value = Roles.class)
public @interface Role {

	String name() default "doctor";
}
