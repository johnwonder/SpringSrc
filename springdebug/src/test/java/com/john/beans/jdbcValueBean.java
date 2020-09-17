package com.john.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/1
 */
public class jdbcValueBean {

	@Value("${url1}")
	private String url;


	public String getUrl() {
		return url;
	}

}
