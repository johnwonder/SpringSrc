package com.john.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description: Profile测试
 * @Author: johnwonder
 * @Date: 2020/7/7
 */
@Configuration
public class RootConfig {

	@Profile("!default1") // 显示的指出defualt~~~
	@Bean("person")
	public ProfilePerson personDefault() {
		return new ProfilePerson("我代表defualt数据源", 0);
	}

	@Profile({"dev", "test"})
	@Bean("person")
	public ProfilePerson personDev() {
		return new ProfilePerson("我代表dev数据源", 66);
	}


	@Profile({"prod", "online"})
	@Bean("person")
	public ProfilePerson personProd() {
		return new ProfilePerson("我代表prod数据源", 88);
	}

}
