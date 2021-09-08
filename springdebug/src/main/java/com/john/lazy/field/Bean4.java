package com.john.lazy.field;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
@Lazy
@Component
public class Bean4 {

	public Bean4() {

		System.out.println("Bean4 initialized");
	}
}
