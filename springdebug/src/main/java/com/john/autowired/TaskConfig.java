package com.john.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/7/25
 */
@Configuration
public class TaskConfig {

	@Bean
	public Task customTask() {
		 return  new CustomTask();
	}

	@Bean
	public Task otherTask() {
		 return  new CustomTask();
	}
}
