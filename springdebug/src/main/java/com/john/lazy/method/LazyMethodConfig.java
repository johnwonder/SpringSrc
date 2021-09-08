package com.john.lazy.method;

import com.john.lazy.Bean1;
import com.john.lazy.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/25
 */
@Component
public class LazyMethodConfig {

	@Lazy
	@Bean
	public Bean1 getBean1(){
		return new Bean1();
	}

	@Bean
	public Bean2 getBean2(){
		return new Bean2();
	}
}
