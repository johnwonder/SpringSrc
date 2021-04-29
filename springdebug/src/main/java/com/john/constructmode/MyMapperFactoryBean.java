package com.john.constructmode;

import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/29
 */
public class MyMapperFactoryBean<T> {

	private Class<T> mapperInterface;

	//构造函数注入 mapperInterface
	public MyMapperFactoryBean(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public String toString() {
		return "MyMapperFactoryBean{" +
				"mapperInterface=" + mapperInterface +
				'}';
	}
}
