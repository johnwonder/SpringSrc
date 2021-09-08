package com.john.primary;

import com.john.dependency.autowire.TestBean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @Description: 继承相同类型TestBean
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
//@Order(-1)
@Component
//@Primary
public class SubTypeBean1 extends ParentBean implements PriorityOrdered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public String toString() {
		return "SubTypeBean1{}";
	}
}
