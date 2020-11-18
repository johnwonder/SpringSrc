package com.john.resource;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/18
 */
public class MyNamespaceDefinitionParse implements BeanDefinitionParser {

	public BeanDefinition parse(Element element, ParserContext parserContext) {
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		// 设置beanClass
		beanDefinition.setBeanClass(MyTagBean.class);
		MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
		// 添加name属性
		if (element.hasAttribute("name")) {
			mutablePropertyValues.addPropertyValue("name", element.getAttribute("name"));
		}
		// 添加package属性
		if (element.hasAttribute("myPackage")) {
			mutablePropertyValues.addPropertyValue("myPackage", element.getAttribute("myPackage"));
		}
		String id = element.getAttribute("id");
		// 拿到注册表, 注册BeanDefinition
		parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
		return beanDefinition;
	}
}
