package com.john.primary;

import com.john.dependency.autowire.TestBean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
//@Order(0)
@Component("testBean")
@Primary
public class SubTypeBean extends ParentBean implements PriorityOrdered {

	private  boolean allowBeanDefinitionOverriding;

	private  Boolean allow;
	@Override
	public int getOrder() {

		return 1;
	}

	@Override
	public String toString() {

		//boolean isBool;
		System.out.println(allowBeanDefinitionOverriding);//为false
		//System.out.println(isBool); 会报错 没有初始化
		System.out.println(allow);//为null
		return "SubTypeBean{}";
	}
}
