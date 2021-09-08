package com.john.lazy.field;

import com.john.lazy.Bean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/15
 */
@Component
public class Bean3 {

	@Lazy
	@Autowired
	private Bean4 bean4;

	public Bean3() {
		System.out.println("Bean3 initialized");
	}

	public Bean4 getBean4() {
		return bean4;
	}

	@Override
	public String toString() {
		return "Bean3{" +
				"bean4=" + bean4 +
				'}';
	}
}
