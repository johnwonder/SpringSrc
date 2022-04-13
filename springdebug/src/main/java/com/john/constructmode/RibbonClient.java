package com.john.constructmode;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/28
 */
@Configuration
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({RibbonClientConfigurationRegistrar.class})
public @interface RibbonClient {

	Class<?>[] defaultConfiguration() default {};
}
