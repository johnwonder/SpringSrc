package com.john.constructmode;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/28
 */
public class RibbonClientConfigurationRegistrar implements ImportBeanDefinitionRegistrar {

	public RibbonClientConfigurationRegistrar() {
	}

	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		Map<String, Object> attrs = metadata.getAnnotationAttributes(RibbonClient.class.getName(), true);


		if (attrs != null && attrs.containsKey("defaultConfiguration")) {
			String name;
			if (metadata.hasEnclosingClass()) {
				name = "default." + metadata.getEnclosingClassName();
			} else {
				name = "default." + metadata.getClassName();
			}

			this.registerClientConfiguration(registry, name, attrs.get("defaultConfiguration"));
		}


	}

	private String getClientName(Map<String, Object> client) {
		if (client == null) {
			return null;
		} else {
			String value = (String)client.get("value");
			if (!StringUtils.hasText(value)) {
				value = (String)client.get("name");
			}

			if (StringUtils.hasText(value)) {
				return value;
			} else {
				throw new IllegalStateException("Either 'name' or 'value' must be provided in @RibbonClient");
			}
		}
	}

	private void registerClientConfiguration(BeanDefinitionRegistry registry, Object name, Object configuration) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RibbonClientSpecification.class);
		builder.addConstructorArgValue(name);
		builder.addConstructorArgValue(configuration);
		registry.registerBeanDefinition(name + ".RibbonClientSpecification", builder.getBeanDefinition());
	}
}
