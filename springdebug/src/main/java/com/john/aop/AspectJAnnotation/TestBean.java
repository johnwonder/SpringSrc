package com.john.aop.AspectJAnnotation;

import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/26
 */
@Component
public class TestBean {

	public void hello() {
		System.out.println("hello");
	}
}
