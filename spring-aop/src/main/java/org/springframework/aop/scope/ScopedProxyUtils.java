/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.scope;

import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.lang.Nullable;

/**
 * Utility class for creating a scoped proxy.
 * Used by ScopedProxyBeanDefinitionDecorator and ClassPathBeanDefinitionScanner.
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 2.5
 */
public abstract class ScopedProxyUtils {

	private static final String TARGET_NAME_PREFIX = "scopedTarget.";


	/**
	 * Generate a scoped proxy for the supplied target bean, registering the target
	 * bean with an internal name and setting 'targetBeanName' on the scoped proxy.
	 * @param definition the original bean definition
	 * @param registry the bean definition registry
	 * @param proxyTargetClass whether to create a target class proxy
	 * @return the scoped proxy definition
	 */
	public static BeanDefinitionHolder createScopedProxy(BeanDefinitionHolder definition,
			BeanDefinitionRegistry registry, boolean proxyTargetClass) {

		String originalBeanName = definition.getBeanName();
		BeanDefinition targetDefinition = definition.getBeanDefinition();
		String targetBeanName = getTargetBeanName(originalBeanName);

		// /保持原来的beanName不变，但是基于原来的bean定义创建代理bean定义,
		 // 保存原来的bean定义到代理bean里面为后面创建代理类做准备.
		//todo 很重要 ScopedProxyFactoryBean 2021-3-23
		// Create a scoped proxy definition for the original bean name,
		// "hiding" the target bean in an internal target definition.
		RootBeanDefinition proxyDefinition = new RootBeanDefinition(ScopedProxyFactoryBean.class);
		proxyDefinition.setDecoratedDefinition(new BeanDefinitionHolder(targetDefinition, targetBeanName));
		proxyDefinition.setOriginatingBeanDefinition(targetDefinition);
		proxyDefinition.setSource(definition.getSource());
		proxyDefinition.setRole(targetDefinition.getRole());

		//这里给targetBeanName 赋值
		proxyDefinition.getPropertyValues().add("targetBeanName", targetBeanName);
		if (proxyTargetClass) {
			targetDefinition.setAttribute(AutoProxyUtils.PRESERVE_TARGET_CLASS_ATTRIBUTE, Boolean.TRUE);

			//ScopedProxyFactoryBean 的 proxyTargetClass 属性默认是true
			// ScopedProxyFactoryBean's "proxyTargetClass" default is TRUE, so we don't need to set it explicitly here.
		}
		else {
			proxyDefinition.getPropertyValues().add("proxyTargetClass", Boolean.FALSE);
		}

		// Copy autowire settings from original bean definition.
		proxyDefinition.setAutowireCandidate(targetDefinition.isAutowireCandidate());
		proxyDefinition.setPrimary(targetDefinition.isPrimary());
		if (targetDefinition instanceof AbstractBeanDefinition) {
			proxyDefinition.copyQualifiersFrom((AbstractBeanDefinition) targetDefinition);
		}

		// The target bean should be ignored in favor of the scoped proxy.
		targetDefinition.setAutowireCandidate(false);
		targetDefinition.setPrimary(false);

		// Register the target bean as separate bean in the factory.
		registry.registerBeanDefinition(targetBeanName, targetDefinition);

		// Return the scoped proxy definition as primary bean definition
		// (potentially an inner bean).
		return new BeanDefinitionHolder(proxyDefinition, originalBeanName, definition.getAliases());
	}

	/**
	 * Generate the bean name that is used within the scoped proxy to reference the target bean.
	 * @param originalBeanName the original name of bean
	 * @return the generated bean to be used to reference the target bean
	 */
	public static String getTargetBeanName(String originalBeanName) {
		return TARGET_NAME_PREFIX + originalBeanName;
	}

	/**
	 * Specify if the {@code beanName} is the name of a bean that references the target
	 * bean within a scoped proxy.
	 * @since 4.1.4
	 */
	public static boolean isScopedTarget(@Nullable String beanName) {
		return (beanName != null && beanName.startsWith(TARGET_NAME_PREFIX));
	}

}
