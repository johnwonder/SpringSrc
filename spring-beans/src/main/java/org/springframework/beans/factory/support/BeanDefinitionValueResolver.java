/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.beans.factory.support;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

//将beandefinition 对象中包含的值解析为应用于目标bean实例的实际值
/**
 * Helper class for use in bean factory implementations,
 * resolving values contained in bean definition objects
 * into the actual values applied to the target bean instance.
 *
 * <p>Operates on an {@link AbstractBeanFactory} and a plain
 * {@link org.springframework.beans.factory.config.BeanDefinition} object.
 * Used by {@link AbstractAutowireCapableBeanFactory}.
 *
 * @author Juergen Hoeller
 * @since 1.2
 * @see AbstractAutowireCapableBeanFactory
 */
class BeanDefinitionValueResolver {

	//继承自 FactoryBeanRegistrySupport -> DefaultSingletonBeanRegistry
	private final AbstractBeanFactory beanFactory;

	//当前正在作用的bean 名称
	private final String beanName;

	//当前正在作用的bean 定义
	private final BeanDefinition beanDefinition;

	//用于属性值 类型转换用
	private final TypeConverter typeConverter;


	/**
	 * Create a BeanDefinitionValueResolver for the given BeanFactory and BeanDefinition.
	 * @param beanFactory the BeanFactory to resolve against
	 * @param beanName the name of the bean that we work on
	 * @param beanDefinition the BeanDefinition of the bean that we work on
	 * @param typeConverter the TypeConverter to use for resolving TypedStringValues
	 */
	public BeanDefinitionValueResolver(
			AbstractBeanFactory beanFactory, String beanName, BeanDefinition beanDefinition, TypeConverter typeConverter) {

		this.beanFactory = beanFactory;
		this.beanName = beanName;
		this.beanDefinition = beanDefinition;
		this.typeConverter = typeConverter;
	}


	//给定一个PropertyValue，返回一个值，必要时解析对工厂中其他bean的任何引用
	/**
	 * Given a PropertyValue, return a value, resolving any references to other
	 * beans in the factory if necessary. The value could be:
	 * <li>A BeanDefinition, which leads to the creation of a corresponding
	 * new bean instance. Singleton flags and names of such "inner beans"
	 * are always ignored: Inner beans are anonymous prototypes.
	 * <li>A RuntimeBeanReference, which must be resolved.
	 * <li>A ManagedList. This is a special collection that may contain
	 * RuntimeBeanReferences or Collections that will need to be resolved.
	 * <li>A ManagedSet. May also contain RuntimeBeanReferences or
	 * Collections that will need to be resolved.
	 * <li>A ManagedMap. In this case the value may be a RuntimeBeanReference
	 * or Collection that will need to be resolved.
	 * <li>An ordinary object or {@code null}, in which case it's left alone.
	 * @param argName the name of the argument that the value is defined for
	 * @param value the value object to resolve
	 * @return the resolved object
	 */
	@Nullable
	public Object resolveValueIfNecessary(Object argName, @Nullable Object value) {

		// We must check each value to see whether it requires a runtime reference
		// to another bean to be resolved.
		//todo ref 属性对应的
		if (value instanceof RuntimeBeanReference) {
			RuntimeBeanReference ref = (RuntimeBeanReference) value;
			return resolveReference(argName, ref);
		}
		else if (value instanceof RuntimeBeanNameReference) {
			//https://blog.csdn.net/caihaijiang/article/details/5903227
			//todo 只是起到验证id bean是否存在的功能 2020-11-03
			String refName = ((RuntimeBeanNameReference) value).getBeanName();

			//todo doEvaluate里还涉及beanExpression 之后再研究 2020-11-04
			refName = String.valueOf(doEvaluate(refName));
			if (!this.beanFactory.containsBean(refName)) {
				throw new BeanDefinitionStoreException(
						"Invalid bean name '" + refName + "' in bean reference for " + argName);
			}
			//还是返回一个名称
			return refName;
		}
		else if (value instanceof BeanDefinitionHolder) {
			// Resolve BeanDefinitionHolder: contains BeanDefinition with name and aliases.
			BeanDefinitionHolder bdHolder = (BeanDefinitionHolder) value;
			return resolveInnerBean(argName, bdHolder.getBeanName(), bdHolder.getBeanDefinition());
		}
		else if (value instanceof BeanDefinition) {
			// Resolve plain BeanDefinition, without contained name: use dummy name.
			BeanDefinition bd = (BeanDefinition) value;
			String innerBeanName = "(inner bean)" + BeanFactoryUtils.GENERATED_BEAN_NAME_SEPARATOR +
					ObjectUtils.getIdentityHexString(bd);
			return resolveInnerBean(argName, innerBeanName, bd);
		}
		else if (value instanceof ManagedArray) {
			// May need to resolve contained runtime references.
			ManagedArray array = (ManagedArray) value;
			Class<?> elementType = array.resolvedElementType;
			if (elementType == null) {
				String elementTypeName = array.getElementTypeName();
				if (StringUtils.hasText(elementTypeName)) {
					try {
						elementType = ClassUtils.forName(elementTypeName, this.beanFactory.getBeanClassLoader());
						array.resolvedElementType = elementType;
					}
					catch (Throwable ex) {
						// Improve the message by showing the context.
						throw new BeanCreationException(
								this.beanDefinition.getResourceDescription(), this.beanName,
								"Error resolving array type for " + argName, ex);
					}
				}
				else {
					elementType = Object.class;
				}
			}
			return resolveManagedArray(argName, (List<?>) value, elementType);
		}
		else if (value instanceof ManagedList) {
			// May need to resolve contained runtime references.
			return resolveManagedList(argName, (List<?>) value);
		}
		else if (value instanceof ManagedSet) {
			// May need to resolve contained runtime references.
			return resolveManagedSet(argName, (Set<?>) value);
		}
		else if (value instanceof ManagedMap) {
			// May need to resolve contained runtime references.
			return resolveManagedMap(argName, (Map<?, ?>) value);
		}
		else if (value instanceof ManagedProperties) {
			Properties original = (Properties) value;
			Properties copy = new Properties();
			original.forEach((propKey, propValue) -> {
				if (propKey instanceof TypedStringValue) {
					propKey = evaluate((TypedStringValue) propKey);
				}
				if (propValue instanceof TypedStringValue) {
					propValue = evaluate((TypedStringValue) propValue);
				}
				if (propKey == null || propValue == null) {
					throw new BeanCreationException(
							this.beanDefinition.getResourceDescription(), this.beanName,
							"Error converting Properties key/value pair for " + argName + ": resolved to null");
				}
				copy.put(propKey, propValue);
			});
			return copy;
		}
		else if (value instanceof TypedStringValue) {
			// Convert value to target type here.
			TypedStringValue typedStringValue = (TypedStringValue) value;

			//支持SpEL表达式
			Object valueObject = evaluate(typedStringValue);
			try {
				//
				Class<?> resolvedTargetType = resolveTargetType(typedStringValue);
				//如果有targetType 还得处理类型转换
				if (resolvedTargetType != null) {
					return this.typeConverter.convertIfNecessary(valueObject, resolvedTargetType);
				}
				else {
					//直接返回evaluate过后的值
					return valueObject;
				}
			}
			catch (Throwable ex) {
				// Improve the message by showing the context.
				throw new BeanCreationException(
						this.beanDefinition.getResourceDescription(), this.beanName,
						"Error converting typed String value for " + argName, ex);
			}
		}
		else if (value instanceof NullBean) {
			return null;
		}
		else {
			return evaluate(value);
		}
	}

	/**
	 * Evaluate the given value as an expression, if necessary.
	 * @param value the candidate value (may be an expression)
	 * @return the resolved value
	 */
	@Nullable
	protected Object evaluate(TypedStringValue value) {
		//表达式解析
		Object result = doEvaluate(value.getValue());
		if (!ObjectUtils.nullSafeEquals(result, value.getValue())) {
			//代表是动态变化的值
			value.setDynamic();
		}
		return result;
	}

	/**
	 * Evaluate the given value as an expression, if necessary.
	 * @param value the original value (may be an expression)
	 * @return the resolved value if necessary, or the original value
	 */
	@Nullable
	protected Object evaluate(@Nullable Object value) {
		if (value instanceof String) {
			return doEvaluate((String) value);
		}
		else if (value instanceof String[]) {
			String[] values = (String[]) value;
			boolean actuallyResolved = false;
			Object[] resolvedValues = new Object[values.length];
			for (int i = 0; i < values.length; i++) {
				String originalValue = values[i];
				Object resolvedValue = doEvaluate(originalValue);
				if (resolvedValue != originalValue) {
					actuallyResolved = true;
				}
				resolvedValues[i] = resolvedValue;
			}
			return (actuallyResolved ? resolvedValues : values);
		}
		else {
			return value;
		}
	}

	/**
	 * Evaluate the given String value as an expression, if necessary.
	 * @param value the original value (may be an expression)
	 * @return the resolved value if necessary, or the original String value
	 */
	@Nullable
	private Object doEvaluate(@Nullable String value) {
		return this.beanFactory.evaluateBeanDefinitionString(value, this.beanDefinition);
	}

	//解析TypedStringValue中的目标类型
	/**
	 * Resolve the target type in the given TypedStringValue.
	 * @param value the TypedStringValue to resolve
	 * @return the resolved target type (or {@code null} if none specified)
	 * @throws ClassNotFoundException if the specified type cannot be resolved
	 * @see TypedStringValue#resolveTargetType
	 */
	@Nullable
	protected Class<?> resolveTargetType(TypedStringValue value) throws ClassNotFoundException {
		if (value.hasTargetType()) {
			return value.getTargetType();
		}
		return value.resolveTargetType(this.beanFactory.getBeanClassLoader());
	}

	/**
	 * Resolve an inner bean definition.
	 * @param argName the name of the argument that the inner bean is defined for
	 * @param innerBeanName the name of the inner bean
	 * @param innerBd the bean definition for the inner bean
	 * @return the resolved inner bean instance
	 */
	@Nullable
	private Object resolveInnerBean(Object argName, String innerBeanName, BeanDefinition innerBd) {
		RootBeanDefinition mbd = null;
		try {
			//获取合并过后的beandefinition scope会带上beanDefinition的scope
			mbd = this.beanFactory.getMergedBeanDefinition(innerBeanName, innerBd, this.beanDefinition);
			// Check given bean name whether it is unique. If not already unique,
			// add counter - increasing the counter until the name is unique.
			String actualInnerBeanName = innerBeanName;
			if (mbd.isSingleton()) {
				//内部会判断容器内部是否已经存在这个名称的bean
				actualInnerBeanName = adaptInnerBeanName(innerBeanName);
			}
			this.beanFactory.registerContainedBean(actualInnerBeanName, this.beanName);
			// Guarantee initialization of beans that the inner bean depends on.
			String[] dependsOn = mbd.getDependsOn();
			if (dependsOn != null) {
				for (String dependsOnBean : dependsOn) {
					this.beanFactory.registerDependentBean(dependsOnBean, actualInnerBeanName);
					this.beanFactory.getBean(dependsOnBean);
				}
			}
			//实际上现在就创建内部bean实例
			// Actually create the inner bean instance now...
			Object innerBean = this.beanFactory.createBean(actualInnerBeanName, mbd, null);
			if (innerBean instanceof FactoryBean) {
				boolean synthetic = mbd.isSynthetic();
				innerBean = this.beanFactory.getObjectFromFactoryBean(
						(FactoryBean<?>) innerBean, actualInnerBeanName, !synthetic);
			}
			if (innerBean instanceof NullBean) {
				innerBean = null;
			}
			return innerBean;
		}
		catch (BeansException ex) {
			throw new BeanCreationException(
					this.beanDefinition.getResourceDescription(), this.beanName,
					"Cannot create inner bean '" + innerBeanName + "' " +
					(mbd != null && mbd.getBeanClassName() != null ? "of type [" + mbd.getBeanClassName() + "] " : "") +
					"while setting " + argName, ex);
		}
	}

	//适配内部bean名称
	/**
	 * Checks the given bean name whether it is unique. If not already unique,
	 * a counter is added, increasing the counter until the name is unique.
	 * @param innerBeanName the original name for the inner bean
	 * @return the adapted name for the inner bean
	 */
	private String adaptInnerBeanName(String innerBeanName) {
		String actualInnerBeanName = innerBeanName;
		int counter = 0;
		while (this.beanFactory.isBeanNameInUse(actualInnerBeanName)) {
			counter++;
			actualInnerBeanName = innerBeanName + BeanFactoryUtils.GENERATED_BEAN_NAME_SEPARATOR + counter;
		}
		return actualInnerBeanName;
	}

	//todo 解析xml配置中的ref属性 引用 2020-11-09
	/**
	 * Resolve a reference to another bean in the factory.
	 */
	@Nullable
	private Object resolveReference(Object argName, RuntimeBeanReference ref) {
		try {
			Object bean;
			String refName = ref.getBeanName();
			refName = String.valueOf(doEvaluate(refName));
			//如果有parent属性就 解析 parent Factory中的
			if (ref.isToParent()) {
				if (this.beanFactory.getParentBeanFactory() == null) {
					throw new BeanCreationException(
							this.beanDefinition.getResourceDescription(), this.beanName,
							"Can't resolve reference to bean '" + refName +
							"' in parent factory: no parent factory available");
				}
				bean = this.beanFactory.getParentBeanFactory().getBean(refName);
			}
			else {
				bean = this.beanFactory.getBean(refName);
				//这里也会注册一个依赖于这个bean的 kv
				this.beanFactory.registerDependentBean(refName, this.beanName);
			}
			if (bean instanceof NullBean) {
				bean = null;
			}
			return bean;
		}
		catch (BeansException ex) {
			//argName == bean property 'maps' with key [TypedStringValue: value [list1], target type [null]]
			throw new BeanCreationException(
					this.beanDefinition.getResourceDescription(), this.beanName,
					"Cannot resolve reference to bean '" + ref.getBeanName() + "' while setting " + argName, ex);
		}
	}

	/**
	 * For each element in the managed array, resolve reference if necessary.
	 */
	private Object resolveManagedArray(Object argName, List<?> ml, Class<?> elementType) {
		Object resolved = Array.newInstance(elementType, ml.size());
		for (int i = 0; i < ml.size(); i++) {
			Array.set(resolved, i,
					resolveValueIfNecessary(new KeyedArgName(argName, i), ml.get(i)));
		}
		return resolved;
	}

	/**
	 * For each element in the managed list, resolve reference if necessary.
	 */
	private List<?> resolveManagedList(Object argName, List<?> ml) {
		List<Object> resolved = new ArrayList<>(ml.size());
		for (int i = 0; i < ml.size(); i++) {
			resolved.add(
					resolveValueIfNecessary(new KeyedArgName(argName, i), ml.get(i)));
		}
		return resolved;
	}

	/**
	 * For each element in the managed set, resolve reference if necessary.
	 */
	private Set<?> resolveManagedSet(Object argName, Set<?> ms) {
		Set<Object> resolved = new LinkedHashSet<>(ms.size());
		int i = 0;
		for (Object m : ms) {
			resolved.add(resolveValueIfNecessary(new KeyedArgName(argName, i), m));
			i++;
		}
		return resolved;
	}

	//todo 解析Map 元素
	/**
	 * For each element in the managed map, resolve reference if necessary.
	 */
	private Map<?, ?> resolveManagedMap(Object argName, Map<?, ?> mm) {

		//最后转为LinkedHashMap
		Map<Object, Object> resolved = new LinkedHashMap<>(mm.size());
		mm.forEach((key, value) -> {
			Object resolvedKey = resolveValueIfNecessary(argName, key);

			//再去循环遍历
			Object resolvedValue = resolveValueIfNecessary(new KeyedArgName(argName, key), value);
			resolved.put(resolvedKey, resolvedValue);
		});
		return resolved;
	}

	//	//2.普通内部类把它理解为与外部类绑定了，创建普通内部类对象一定要通过外部类的对象new才行。而静态内部类是不需要的。
	//BeanDefinitionValueResolver.NormalInsideKeyedArgName normalInsideKeyedArgName = valueResolver.new NormalInsideKeyedArgName();
//	class  NormalInsideKeyedArgName{
//
//	}


	//静态内部类的使用场景： 为了抛出异常 的时候 toString 使用
	//https://www.cnblogs.com/heavenplus/p/9451181.html
	//1.静态内部类对外部类的访问是有局限的，如不能访问外部类的非静态成员与变量（这是它的最大限制，也是使用频率上输给普通内部类的原因）

	//私有静态内部类
	//为了只会toString()的使用，比如抛出异常的时候
	/**
	 * Holder class used for delayed toString building.
	 */
	private static class KeyedArgName {

		private final Object argName;

		private final Object key;

		public KeyedArgName(Object argName, Object key) {
			this.argName = argName;
			this.key = key;
		}

		@Override
		public String toString() {
			//'maps' with key [TypedStringValue: value [list1], target type [null]]
			return this.argName + " with key " + BeanWrapper.PROPERTY_KEY_PREFIX +
					this.key + BeanWrapper.PROPERTY_KEY_SUFFIX;
		}
	}

}
