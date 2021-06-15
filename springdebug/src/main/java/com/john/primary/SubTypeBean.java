package com.john.primary;

import com.john.dependency.autowire.TestBean;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

import javax.annotation.Priority;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
@Order(0)
public class SubTypeBean extends ParentBean implements PriorityOrdered {

	@Override
	public int getOrder() {

		return 1;
	}

	@Override
	public String toString() {
		return "SubTypeBean{}";
	}
}
