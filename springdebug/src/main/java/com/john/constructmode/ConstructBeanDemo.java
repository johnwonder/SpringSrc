package com.john.constructmode;

import com.john.javabase.abstractclass.AbstractBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/29
 */
@ComponentScan
public class ConstructBeanDemo {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext();

		ac.register(ConstructBeanDemo.class);

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
		AbstractBeanDefinition definition =builder.getBeanDefinition();
		definition.getConstructorArgumentValues().addGenericArgumentValue("com.john.constructmode.IBaseMapper"); // issue #59
		definition.setBeanClass(MyMapperFactoryBean.class);
		ac.registerBeanDefinition("mapper",definition);
		ac.refresh();
		//System.out.println(ac.getBean("staticCar"));
		//System.out.println(ac.getBean("car1"));

		MyMapperFactoryBean mapper = (MyMapperFactoryBean)ac.getBean("mapper");
		System.out.println(mapper);
	}
}
