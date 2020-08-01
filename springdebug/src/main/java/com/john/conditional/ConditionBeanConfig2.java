package com.john.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 */
@Configuration
@Conditional({MyConfigurationCondition1.class})
public class ConditionBeanConfig2 {

	@Bean
	public String name() {
		return "路人甲Java";
	}
}
