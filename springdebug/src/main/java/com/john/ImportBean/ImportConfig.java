package com.john.ImportBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
//https://www.jianshu.com/p/8378b9f491ae 基于@Component注解
@ComponentScan("com.john.ImportBean")
@ImportTest
@Configuration
public class ImportConfig {

	public ImportConfig() {

		System.out.println("ImportConfig");
	}
}
