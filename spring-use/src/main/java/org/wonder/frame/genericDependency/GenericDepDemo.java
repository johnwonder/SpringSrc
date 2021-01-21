package org.wonder.frame.genericDependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/16
 */
@ComponentScan
public class GenericDepDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=  new AnnotationConfigApplicationContext();

		applicationContext.register(GenericDepDemo.class);
		applicationContext.refresh();

		UserService<Emploee> userService = applicationContext.getBean(UserService.class);

		//User user = new User();
		userService.service();
	}
}
