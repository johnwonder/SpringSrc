package com.john.configurationclass;

import org.springframework.context.annotation.Bean;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/28
 */
public interface ConfigurationInterface {

	@Bean
	static Person getPerson(){
		Person p = new Person();
		p.setName("john wonder");
		return p;
	}
}
