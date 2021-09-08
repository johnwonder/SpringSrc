package org.wonder.frame.importandfilter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/8/18
 */
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type =  FilterType.ASSIGNABLE_TYPE,value = { ImportConfig.class })})
@Import(ImportConfig.class)
//@ComponentScan
public class ImportAfterFilterDemo implements ApplicationContextAware {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext();
		applicationContext.register(ImportAfterFilterDemo.class);
		applicationContext.refresh();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		System.out.println(applicationContext.getBean(ImportBean.class));
	}
}
