package org.wonder.frame.beanPropertiesOrder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class BeanPropertyOrderDemo {

	//https://coderanch.com/t/410001/java/Sequence-Properties-returned-BeanInfo-getPropertyDescriptors
	//The API documentation of BeanInfo.getPropertyDescriptors() does not say that it returns properties in a certain order (alphabetical or otherwise). So, the order is undefined. That you see them in alphabetical order should be considered as a coincidence - there is no guarantee that you will get them in alphabetical order.
	//
	//So prefixing names may work, but it may not work in an older or newer version of Java - the order is simply unspecified. If you want the properties in alphabetical order, you should sort the array returned by getPropertyDescriptors() yourself.
	//
	//There's no way to get the properties in the order as defined in the source code of the bean.
	public static void main(String[] args) {

		//https://www.cnblogs.com/zhuyeshen/p/12936912.html
		ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-config-mapper.xml");
		MapperBean mapper=(MapperBean)context.getBean("mapper");


		System.out.println(mapper);
	}
}
