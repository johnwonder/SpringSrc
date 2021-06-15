package com.john.autowire.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/5/18
 */
@Component
public class BeanManager {

	@Autowired
	private  List<BeanOperator> beanOperators;

	@Override
	public String toString() {

		if(beanOperators != null){

			StringJoiner beanSj = new StringJoiner(",");
			for (BeanOperator beanOperator : beanOperators) {
				beanSj.add(beanOperator.toString());
			}
			return  beanSj.toString();
		}
		return "BeanManager{" +
				"beanOperators=" + beanOperators +
				'}';
	}
}
