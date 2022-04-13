package com.john.applicationContext;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/1/8
 */
public class ApplicationContextDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationAppContext = new AnnotationConfigApplicationContext();

		annotationAppContext.register(BeanFactoryAnotationArgsApp.class);
		annotationAppContext.refresh();

		ApplicationContext  applicationContext = annotationAppContext;

		//继承自ListableBeanFactory接口
		//输出12个bean
		System.out.println(applicationContext.getBeanDefinitionCount());


		//输出[org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor,
		// org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, beanFactoryAnotationArgsApp, article, configArgClass, findByBeanAnnotationDemo.ConfigBean, findByBeanAnnotationDemo, index, singer]
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

		//执行了 InitializingBean bean生命周期方法
		applicationContext.getAutowireCapableBeanFactory().createBean(AutowireBean.class);

		//还获取不到 会报错
		///System.out.println(applicationContext.getBean(AutowireBean.class));

		AutowireBean autowireBean = new AutowireBean();

		//autowireBean 注入带注解的属性
		//因为 AnnotationConfigApplicationContext 加入了 AutowiredAnnotationBeanPostProcessor
		applicationContext.getAutowireCapableBeanFactory().autowireBean(autowireBean);
		// setArticleService 设置了 @Autowired 就可以了
		System.out.println(autowireBean.getArticleService());

		//使用autowireBeanProperties 可以注入不带注解的属性
		applicationContext.getAutowireCapableBeanFactory().autowireBeanProperties(autowireBean, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,false);
		System.out.println(autowireBean.getArticle());

		//必须存在beandefinition
		//applicationContext.getAutowireCapableBeanFactory().configureBean(autowireBean,"aaa");

		//调用了InitializingBean接口方法
		AutowireBean autowireBean1 = new AutowireBean();
		applicationContext.getAutowireCapableBeanFactory().initializeBean(autowireBean1,"ss");
	}
}
