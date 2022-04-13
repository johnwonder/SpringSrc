package com.john.constructmode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/28
 */
@Configuration
public class RibbonClientConfiguration {

	@Bean
	public ServerList<?> ribbonServerList() {
	 		return  new ServerList<>();
	}
}
