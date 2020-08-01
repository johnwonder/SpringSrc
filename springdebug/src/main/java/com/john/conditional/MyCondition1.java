package com.john.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 */
public class MyCondition1 implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		//获取spring容器
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//判断容器中是否存在Service类型的bean
		boolean existsService = !beanFactory.getBeansOfType(ConditionService.class).isEmpty();
		return existsService;
	}
}
