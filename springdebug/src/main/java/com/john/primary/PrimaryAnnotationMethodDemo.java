package com.john.primary;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * @Description: @Primary注解用于@Bean注解的方法
 * @Author: johnwonder
 * @Date: 2021/6/12
 */
public class PrimaryAnnotationMethodDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(PrimaryAnnotationMethodDemo.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(SameTypeBean.class));
	}

	@Bean
	@Primary
	SameTypeBean sameTypeBean(ObjectProvider<SameTypeBean> sameTypeBeanList){

		sameTypeBeanList.stream().forEach(System.out::println);
		//System.out.println(sameTypeBeanList.size());

		return new SameTypeBean()
				;
	}

	@Bean
	SameTypeBean anotherSameTypeBean(){
		return new SameTypeBean();
	}

	@Bean
	SameTypeBean anotherSameTypeBean1(){
		return new SameTypeBean();
	}


	static class SameTypeBean {

	}
}


