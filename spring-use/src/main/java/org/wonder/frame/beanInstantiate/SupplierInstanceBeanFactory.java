package org.wonder.frame.beanInstantiate;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wonder.frame.beanInstantiate.supplier.ComponentBeanDefinition;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/12
 */
public class SupplierInstanceBeanFactory {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) ctx.getBeanFactory();

		registry.registerBeanDefinition("supplierBean",new ComponentBeanDefinition());

		ctx.refresh();

		System.out.println(ctx.getBean("supplierBean"));
	}
}
