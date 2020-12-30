package com.john.dependency.autowire;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class TestBeanDep implements BeanNameAware {


	@Override
	public void setBeanName(String name) {

		System.out.println("setBeanName: " +name);

	}
}
