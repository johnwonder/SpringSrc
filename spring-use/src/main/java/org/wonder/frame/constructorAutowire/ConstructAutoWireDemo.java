package org.wonder.frame.constructorAutowire;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.wonder.frame.beanInstantiate.supplier.ComponentBeanDefinition;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/15
 */
@ComponentScan
public class ConstructAutoWireDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(ConstructAutoWireDemo.class);
		ctx.refresh();

		System.out.println(ctx.getBean(ContructorA.class));
	}
}
