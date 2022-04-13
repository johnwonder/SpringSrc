package com.john.ImportBean;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BeanDefinitionRegistrar.class,ImportBeanFactory.class})
public @interface ImportTest {


}
