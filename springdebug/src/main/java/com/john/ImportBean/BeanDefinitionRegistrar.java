package com.john.ImportBean;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/25
 */
@Configuration
public abstract class BeanDefinitionRegistrar implements   ImportAware {
	public BeanDefinitionRegistrar() {

		System.out.println("BeanDefinitionRegistrar");
	}

	//	@Override
//	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//
//		List<Class> mappers = new ArrayList<>();
//		mappers.add(UserMapper.class);
//		mappers.add(OrderMapper.class);
//
//		for (Class mapper : mappers) {
//
//			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
//			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
//
//
//			beanDefinition.setBeanClass(ImportBeanFactory.class);
//
//			//如果写死UserMapper的话 因为autowired默认是根据 type来注入的 所以会报如下错误
//			//No qualifying bean of type 'com.john.ImportBean.UserMapper' available: expected single matching bean but found 2: UserMapper,OrderMapper
//			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
////			if(mapper ==UserMapper.class)
////			beanDefinition.setPrimary(true);
////			System.out.println(mapper.getSimpleName());
//			//todo 这里注册了两个 UserMapper Bean 2020-11-17
//			registry.registerBeanDefinition(mapper.getSimpleName(),beanDefinition);
//		}
//	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {

		//实现了ImportBeanDefinitionRegistrar 接口的类将不会触发这个方法
		System.out.println(importMetadata);
	}
}
