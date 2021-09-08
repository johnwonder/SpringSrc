package com.john.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
@Lazy
@Configuration
@ComponentScan(basePackages = "com.example.demo.lazy")
public class LazyConfigBean {
	@Bean
	public Bean1 getBean1(){
		return new Bean1();
	}

	@Bean
	public Bean2 getBean2(){
		return new Bean2();
	}
}
