package com.john.lazy.contruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/25
 */
//@Component
//@Lazy
public class DependencyBean {

	public DependencyBean() {
		System.out.println("dependency bean init");
	}
}
