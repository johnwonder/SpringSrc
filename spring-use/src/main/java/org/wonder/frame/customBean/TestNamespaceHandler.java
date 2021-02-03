/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wonder.frame.customBean;

import org.springframework.aop.config.AbstractInterceptorDrivenBeanDefinitionDecorator;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



/**
 * Custom namespace handler implementation.
 *
 * @author Rob Harrop
 */
final class TestNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {

		//注册parser
		registerBeanDefinitionParser("testBean", new TestBeanDefinitionParser());
		registerBeanDefinitionParser("person", new PersonDefinitionParser());

		//注册element的 decorater
		registerBeanDefinitionDecorator("set", new PropertyModifyingBeanDefinitionDecorator());
		registerBeanDefinitionDecorator("debug", new DebugBeanDefinitionDecorator());
		//registerBeanDefinitionDecorator("nop", new NopInterceptorBeanDefinitionDecorator());

		//注册 attr的 decorator
		registerBeanDefinitionDecoratorForAttribute("object-name", new ObjectNameBeanDefinitionDecorator());
	}


	private static class TestBeanDefinitionParser implements BeanDefinitionParser {

		@Override
		public BeanDefinition parse(Element element, ParserContext parserContext) {

			RootBeanDefinition definition = new RootBeanDefinition();
			definition.setBeanClass(CustomBean.class);

			MutablePropertyValues mpvs = new MutablePropertyValues();
			mpvs.add("name", element.getAttribute("name"));
			mpvs.add("age", element.getAttribute("age"));

			//1.设置beanDefinition的 属性 propertyValues
			definition.setPropertyValues(mpvs);

			//2.获取到beanDefinition的 registry
			parserContext.getRegistry().registerBeanDefinition(element.getAttribute("id"), definition);
			return null;
		}
	}


	private static final class PersonDefinitionParser extends AbstractSingleBeanDefinitionParser {

		@Override
		protected Class<?> getBeanClass(Element element) {
			return CustomBean.class;
		}

		@Override
		protected void doParse(Element element, BeanDefinitionBuilder builder) {
			builder.addPropertyValue("name", element.getAttribute("name"));
			builder.addPropertyValue("age", element.getAttribute("age"));
		}
	}


	private static class PropertyModifyingBeanDefinitionDecorator implements BeanDefinitionDecorator {

		@Override
		public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
			Element element = (Element) node;
			//1.获取BeanDefinition
			BeanDefinition def = definition.getBeanDefinition();

			MutablePropertyValues mpvs = (def.getPropertyValues() == null) ? new MutablePropertyValues() : def.getPropertyValues();
			mpvs.add("name", element.getAttribute("name"));
			mpvs.add("age", element.getAttribute("age"));

			((AbstractBeanDefinition) def).setPropertyValues(mpvs);
			return definition;
		}
	}


	private static class DebugBeanDefinitionDecorator extends AbstractInterceptorDrivenBeanDefinitionDecorator {

		@Override
		protected BeanDefinition createInterceptorDefinition(Node node) {
			return new RootBeanDefinition(DebugInterceptor.class);
		}
	}


//	private static class NopInterceptorBeanDefinitionDecorator extends AbstractInterceptorDrivenBeanDefinitionDecorator {
//
//		@Override
//		protected BeanDefinition createInterceptorDefinition(Node node) {
//			return new RootBeanDefinition(NopInterceptor.class);
//		}
//	}


	private static class ObjectNameBeanDefinitionDecorator implements BeanDefinitionDecorator {

		@Override
		public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
			Attr objectNameAttribute = (Attr) node;
			definition.getBeanDefinition().setAttribute("objectName", objectNameAttribute.getValue());
			return definition;
		}
	}

}
