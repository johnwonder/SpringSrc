package com.john.xmlconfig.decorate;

import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/13
 */
public class DecorateBeanDemo {

	public static void main(String[] args) {

		//NamespaceHandlerResolver resolver = new DefaultNamespaceHandlerResolver(CLASS.getClassLoader(), NS_PROPS);
		GenericApplicationContext beanFactory = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		//reader.setNamespaceHandlerResolver(resolver);
		reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
		//reader.setEntityResolver(new DummySchemaResolver());
		//reader.loadBeanDefinitions(getResource());
		//this.beanFactory.refresh();
	}
}
