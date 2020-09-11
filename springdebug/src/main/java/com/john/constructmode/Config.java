package com.john.constructmode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/30
 */
//@ComponentScan("com.john.constructmode")
@Configuration
public class Config {

//	@Bean()
//	public  Service service(){
//		return  new Service();
//	}

	@Bean()
	public  Service service(){
		return  new Service();
	}
}
