package com.john;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/14
 */
public class MyXmlApplicationContext extends ClassPathXmlApplicationContext {


	public MyXmlApplicationContext(String configLocation) throws BeansException {
		super(configLocation);
	}

	public MyXmlApplicationContext(String... configLocations) throws BeansException {
		super(configLocations);
	}

	public MyXmlApplicationContext(String[] configLocations, @Nullable ApplicationContext parent) throws BeansException {
		super(configLocations, parent);
	}

	@Override
	protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		super.prepareBeanFactory(beanFactory);

		//value注解解析
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor =new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		DefaultListableBeanFactory beanFactory1 = (DefaultListableBeanFactory)beanFactory;
		//todo important 不加这行就不能解析
		beanFactory1.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());

	}
}
