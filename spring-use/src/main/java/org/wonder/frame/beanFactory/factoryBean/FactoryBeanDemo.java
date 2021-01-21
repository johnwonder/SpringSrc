package org.wonder.frame.beanFactory.factoryBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/16
 */
@ComponentScan
public class FactoryBeanDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=  new AnnotationConfigApplicationContext();

		applicationContext.register(FactoryBeanDemo.class);
		applicationContext.refresh();
		BeanFactory beanFactory = applicationContext;

		//获取FactoryBean定义的bean
		//System.out.println(beanFactory.isPrototype("fruit"));

		//1.如果FactoryBean定义为prototype 那么获取FactoryBean本身 也是prototype
		//2.如果FactoryBean是singleton 那获取FactoryBean本身肯定是singleton
		//3.如果FactoryBean是singleton 那获取FactoryBean要创建的对象时，如果要创建的对象不是singleton ,那么就返回false
		System.out.println(beanFactory.isPrototype("fruit"));
	}
}
