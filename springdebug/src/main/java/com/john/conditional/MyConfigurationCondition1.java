package com.john.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/8
 * https://zhuanlan.zhihu.com/p/136706525
 */
public class MyConfigurationCondition1 implements ConfigurationCondition {

	//Cannot enhance @Configuration bean definition 'com.john.conditional.ConditionBeanConfig1' since its singleton instance has been created too early. The typical cause is a non-static @Bean method with a BeanDefinitionRegistryPostProcessor return type: Consider declaring such methods as 'static'.
	@Override
	public ConfigurationPhase getConfigurationPhase() {
		return ConfigurationPhase.REGISTER_BEAN;
	}

	//如果是在configurationclass解析阶段 那么就获取不到 他定义的bean
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		//获取spring容器
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//判断容器中是否存在Service类型的bean
		boolean existsService = !beanFactory.getBeansOfType(ConditionService.class).isEmpty();
		return existsService;
	}
}
