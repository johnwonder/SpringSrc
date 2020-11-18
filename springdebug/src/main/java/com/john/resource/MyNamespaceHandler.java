package com.john.resource;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	public void init() {
		registerBeanDefinitionParser("annotation", new MyNamespaceDefinitionParse());
	}
}
