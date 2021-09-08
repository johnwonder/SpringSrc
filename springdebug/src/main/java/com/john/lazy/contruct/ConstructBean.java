package com.john.lazy.contruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/25
 */
//@Component
//@Scope("prototype")
public class ConstructBean {

	private  final  DependencyBean bean;

	@Autowired

	public ConstructBean(@Lazy DependencyBean dependencyBean) {

		bean = dependencyBean;
		System.out.println("construct bean loaded");
	}

	//@Autowired
	public ConstructBean(@Lazy DependencyBean dependencyBean,String name ) {

		bean = dependencyBean;

		System.out.println("construct bean loaded");
	}

	@Override
	public String toString() {
		return "ConstructBean{" +
				"bean=" + bean +
				'}';
	}


	public DependencyBean getBean() {
		return bean;
	}
}
