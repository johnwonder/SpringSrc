package org.wonder.frame.beanFactory.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/18
 */
@Component("fruit")
//@Scope("prototype")
public class FruitFactoryBean  implements FactoryBean<Fruit> {
	@Override
	public Fruit getObject() throws Exception {
		Fruit fruit = new Fruit();
		return  fruit;
	}

	@Override
	public Class<?> getObjectType() {
		return Fruit.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
