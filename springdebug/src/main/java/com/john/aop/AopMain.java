package com.john.aop;

import com.john.aop.AspectJAnnotation.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/10/26
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy // 要加上这个
public class AopMain {

	//https://www.cnblogs.com/niechen/p/9016816.html
	//https://www.cnblogs.com/feng9exe/p/12061465.html
	//https://blog.csdn.net/wenbingoon/article/details/8988553
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopMain.class);
		TestBean testBean = ctx.getBean(TestBean.class);
		System.out.println(testBean);
		testBean.hello();
	}
}
