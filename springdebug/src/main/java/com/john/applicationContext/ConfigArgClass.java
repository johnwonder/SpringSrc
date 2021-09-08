package com.john.applicationContext;

import com.john.beanFactory.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/6
 */
@Configuration
public class ConfigArgClass {

	@Bean("singer")
	@Scope("prototype")
	public Singer createSinger(String country,String gender){

		return  new Singer(country,gender,"");
	}
}
