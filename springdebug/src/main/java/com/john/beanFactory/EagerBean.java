package com.john.beanFactory;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/20
 */
public class EagerBean {

	//本身是个factoryBean
	public MyFactoryBean createMyBean(){

		System.out.println("init MyFactoryBean ");
		return  new MyFactoryBean();
	}
}
