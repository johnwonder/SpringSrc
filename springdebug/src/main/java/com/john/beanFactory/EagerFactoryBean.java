package com.john.beanFactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/20
 */
public class EagerFactoryBean implements FactoryBean<EagerBean> {

	@Override
	public EagerBean getObject() throws Exception {
		return new EagerBean();
	}

	@Override
	public Class<?> getObjectType() {
		return EagerBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
