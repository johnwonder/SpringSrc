/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.beans;

import org.springframework.core.AttributeAccessorSupport;
import org.springframework.lang.Nullable;

//https://blog.csdn.net/vistaed/article/details/108011144
//主要重写了 AttributeAccessorSupport 的部分方法，限定操作为 BeanMetadataAttribute
//也就是说属性的上下文操作重写为 增删改查：BeanMetadataAttribute
//由于父类操作的是Object类型 ，所以进行一个重写 ，限定是 BeanMetadataAttribute
/**
 * Extension of {@link org.springframework.core.AttributeAccessorSupport},
 * holding attributes as {@link BeanMetadataAttribute} objects in order
 * to keep track of the definition source.
 *
 * @author Juergen Hoeller
 * @since 2.5
 */
@SuppressWarnings("serial")
public class BeanMetadataAttributeAccessor extends AttributeAccessorSupport implements BeanMetadataElement {

	//BeanMetadata 和 AttributeAccessor的组合
	@Nullable
	private Object source;


	//对象的确切类型 依赖于 使用的配置机制
	/**
	 * Set the configuration source {@code Object} for this metadata element.
	 * <p>The exact type of the object will depend on the configuration mechanism used.
	 */
	public void setSource(@Nullable Object source) {
		this.source = source;
	}

	//todo 实现了BeanMetadataElement接口
	@Override
	@Nullable
	public Object getSource() {
		return this.source;
	}


	//todo BeanMetadataAttribute 是 BeanMetadataElement 的实现 2020-09-29
	/**
	 * Add the given BeanMetadataAttribute to this accessor's set of attributes.
	 * @param attribute the BeanMetadataAttribute object to register
	 */
	public void addMetadataAttribute(BeanMetadataAttribute attribute) {
		super.setAttribute(attribute.getName(), attribute);
	}

	/**
	 * Look up the given BeanMetadataAttribute in this accessor's set of attributes.
	 * @param name the name of the attribute
	 * @return the corresponding BeanMetadataAttribute object,
	 * or {@code null} if no such attribute defined
	 */
	@Nullable
	public BeanMetadataAttribute getMetadataAttribute(String name) {
		return (BeanMetadataAttribute) super.getAttribute(name);
	}

	@Override
	public void setAttribute(String name, @Nullable Object value) {
		super.setAttribute(name, new BeanMetadataAttribute(name, value));
	}

	@Override
	@Nullable
	public Object getAttribute(String name) {
		BeanMetadataAttribute attribute = (BeanMetadataAttribute) super.getAttribute(name);
		return (attribute != null ? attribute.getValue() : null);
	}

	@Override
	@Nullable
	public Object removeAttribute(String name) {
		BeanMetadataAttribute attribute = (BeanMetadataAttribute) super.removeAttribute(name);
		return (attribute != null ? attribute.getValue() : null);
	}

}
