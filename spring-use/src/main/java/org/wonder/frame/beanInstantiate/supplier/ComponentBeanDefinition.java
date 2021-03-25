package org.wonder.frame.beanInstantiate.supplier;

import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.function.Supplier;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/12
 */
public class ComponentBeanDefinition extends GenericBeanDefinition {

	@Override
	public Supplier<?> getInstanceSupplier() {

		return SupplierBean::new;
	}
}
