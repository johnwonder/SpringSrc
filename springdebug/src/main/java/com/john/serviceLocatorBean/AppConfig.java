package com.john.serviceLocatorBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
@Configuration
@ComponentScan("com.john.serviceLocatorBean")
public class AppConfig {

	@Bean
	public FactoryBean parserFactory() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();

		Properties properties = new Properties();
		properties.setProperty("j", "jsonParser");
		properties.setProperty("x", "xmlParser");

		factoryBean.setServiceMappings(properties);
		factoryBean.setServiceLocatorInterface(ParserFactory.class); //指定的是 ParserFactory 接口
		return factoryBean;
	}
}
