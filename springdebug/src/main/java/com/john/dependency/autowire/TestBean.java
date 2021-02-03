package com.john.dependency.autowire;


import com.john.domain.MovieFinder;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/22
 */
public class TestBean implements BeanNameAware{

	private TestBeanDep beanDep;

	private String beanName;

	@Override
	public void setBeanName(String name) {


		System.out.println("setBeanName: " +name);
	}

	public void setBeanDep(TestBeanDep beanDep) {
		System.out.println("beanDep注入"+beanDep);
		this.beanDep = beanDep;
	}

	@Override
	public String toString() {
		return "TestBean{" +
				"beanDep=" + beanDep +
				'}';
	}
}
