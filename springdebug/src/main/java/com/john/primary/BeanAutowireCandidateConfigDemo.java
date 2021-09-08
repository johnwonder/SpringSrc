package com.john.primary;

import com.john.dependency.autowire.TestBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class BeanAutowireCandidateConfigDemo {

	public static void main( String[] args ) {


		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config-autowire-canidate.xml");

		//有两个类型的TestBean 情况下，其中一个可以把AutowireCandidate 设置为false 或者把primary设置为true
		//TestBean testBean=(TestBean)context.getBean(TestBean.class);
		//System.out.println(testBean);


		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)context.getBeanFactory();
		//实现@Priority 注解
		//beanFactory.setDependencyComparator(PriorityOrderComparator.INSTANCE);
		ParentBean testBean= context.getBean(ParentBean.class);
		System.out.println(testBean);
	}

}
