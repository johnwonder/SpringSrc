package com.john.lazy;

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
	public Region getRegion(){
		return new Region();
	}

	@Bean
	public Country getCountry(){
		return new Country();
	}
}
