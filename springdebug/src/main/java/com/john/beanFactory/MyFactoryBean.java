package com.john.beanFactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/20
 */
public class MyFactoryBean implements FactoryBean<MyBean> {

	@Override
	public MyBean getObject() throws Exception {
		return new MyBean();
	}

	@Override
	public Class<?> getObjectType() {
		return MyBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
