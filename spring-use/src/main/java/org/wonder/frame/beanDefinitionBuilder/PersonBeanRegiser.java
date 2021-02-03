package org.wonder.frame.beanDefinitionBuilder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/2
 */
public class PersonBeanRegiser implements BeanFactoryAware {

	private BeanFactory beanFactory;

	@PostConstruct
	public void register(){
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
		builder.addPropertyValue("name", "张三");
		builder.addPropertyValue("age", 20);
		//重点
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) this.beanFactory;
		registry.registerBeanDefinition("person", builder.getBeanDefinition());
	}

	/**
	 *
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PersonBeanRegiser.class);
		Person person = ctx.getBean(Person.class);
		System.out.println(person.getName());
	}
}
