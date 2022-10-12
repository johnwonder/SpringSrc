package org.wonder.frame.autowire;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/6
 */
@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TestQualifier {
}
