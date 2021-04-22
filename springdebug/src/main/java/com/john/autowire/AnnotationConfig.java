package com.john.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/12/30
 */
//@Component
public class AnnotationConfig {

	@Autowired
	AutowireTest1 autowireTest1;


	@Resource
	AutowireTest2 autowireTest2;

	@Override
	public String toString() {
		return "AnnotationConfig{" +
				"autowireTest1=" + autowireTest1 +
				", autowireTest2=" + autowireTest2 +
				'}';
	}
}
