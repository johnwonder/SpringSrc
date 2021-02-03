package com.john.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan
public class BeanLookupMethodApp
{
    public static void main( String[] args )
    {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(BeanLookupMethodApp.class);
		applicationContext.refresh();

		AbstractLookupBean lookupBean = (AbstractLookupBean) applicationContext.getBean("article1");
		System.out.println(lookupBean.testLookup("测试构造函数参数"));

	}


}
