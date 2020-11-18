package com.john.yaml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/14
 */
public class YamlReaderDemo {

	public static void main(String[] args) {

		YamlPropertiesFactoryBean yamlMapFactoryBean = new YamlPropertiesFactoryBean();
		yamlMapFactoryBean.setResources(new ClassPathResource("application.yml"));
		Properties properties = yamlMapFactoryBean.getObject();
		//获取yml里的参数

		 String active = properties.getProperty("spring.profiles.active");
		 System.out.println("active:"+active);
	}
}
