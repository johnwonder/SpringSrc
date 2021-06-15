package com.john.primary;

import org.springframework.core.DecoratingProxy;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.OrderUtils;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/13
 */
public class PriorityOrderComparator extends AnnotationAwareOrderComparator {

	/**
	 * Shared default instance of {@code AnnotationAwareOrderComparator}.
	 */
	public static final PriorityOrderComparator INSTANCE = new PriorityOrderComparator();

	@Override
	public Integer getPriority(Object obj) {

		 Integer order = super.getPriority(obj);
		 if(order == null)
		 	return  super.findOrder(obj);
		 return  order;
	}
}
