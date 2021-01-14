package com.john.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MyBeanFactory implements BeanFactoryAware {

	private static MyBeanFactory myBeanFactory;

	private static BeanFactory beanFactory;

	//回调方法
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		// TODO Auto-generated method stub
		//this.beanFactory = factory;
		System.out.println("==>>>>setBeanFactory<<<<<<==");
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public static MyBeanFactory getInstance(){

		if(myBeanFactory==null){
			myBeanFactory = (MyBeanFactory) beanFactory.getBean("myBeanFactory");
		}


		return myBeanFactory;

	}

	public static Object getBean(String beanName){

		return beanFactory.getBean(beanName);

	}

	public static Object getBean(String beanName, Class clazz){

		return beanFactory.getBean(beanName, clazz);

	}

}
