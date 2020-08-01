package com.john.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 */
@Configuration
public class ConditionBeanConfig1 {

	@Bean
	public ConditionService conditionService(){
		return  new ConditionService();
	}
}
