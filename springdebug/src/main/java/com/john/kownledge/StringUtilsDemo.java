package com.john.kownledge;

import org.springframework.util.StringUtils;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/17
 */
public class StringUtilsDemo {

	public static void main(String[] args) {

		String relativePath = StringUtils.applyRelativePath("spring/", "/config");

		//打印出 spring/config
		System.out.println(relativePath);
	}
}
