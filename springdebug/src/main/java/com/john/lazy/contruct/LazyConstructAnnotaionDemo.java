package com.john.lazy.contruct;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
@ComponentScan
public class LazyConstructAnnotaionDemo {

	//https://spring.io/blog/2019/03/14/lazy-initialization-in-spring-boot-2-2
	//https://spring.io/blog/2016/03/04/core-container-refinements-in-spring-framework-4-3
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		RootBeanDefinition abd = new RootBeanDefinition(ConstructBean.class);
		abd.setScope(RootBeanDefinition.SCOPE_PROTOTYPE);
		ac.registerBeanDefinition("annotatedBean", abd);
		RootBeanDefinition tbd = new RootBeanDefinition(DependencyBean.class);
		tbd.setLazyInit(true);
		ac.registerBeanDefinition("testBean", tbd);
		ac.refresh();


		ConstructBean constructBean = ac.getBean(ConstructBean.class);

		//获取依赖的时候 代理拦截
		System.out.println("开始访问依赖bean");
		System.out.println(constructBean.getBean());
		//https://blog.csdn.net/niugang0920/article/details/115900565
		//需要字段和 类上都标注 @Lazy 注解
		//System.out.println(bean3.getBean4());
	}
}
