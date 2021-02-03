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

package org.springframework.beans.factory;

//FactoryBean接口的扩展。实现可能会指出它们是否总是返回独立的实例，
// 例如FactoryBean.isSingleton（）返回false的实现并不清楚地表示独立实例

//没有实现这个扩展接口的普通FactoryBean实现被简单地假设为总是返回独立的实例，
// 如果它们的FactoryBean.isSingleton 实现返回false；
// 仅根据需要访问公开的对象

//此接口是一个专用接口，主要用于框架内和协作框架内的内部使用。
// 一般来说，应用程序提供的FactoryBeans应该简单地实现普通FactoryBean接口。
// 即使在点版本中，新方法也可能添加到此扩展接口
/**
 * Extension of the {@link FactoryBean} interface. Implementations may
 * indicate whether they always return independent instances, for the
 * case where their {@link #isSingleton()} implementation returning
 * {@code false} does not clearly indicate independent instances.
 *
 * <p>Plain {@link FactoryBean} implementations which do not implement
 * this extended interface are simply assumed to always return independent
 * instances if their {@link #isSingleton()} implementation returns
 * {@code false}; the exposed object is only accessed on demand.
 *
 * <p><b>NOTE:</b> This interface is a special purpose interface, mainly for
 * internal use within the framework and within collaborating frameworks.
 * In general, application-provided FactoryBeans should simply implement
 * the plain {@link FactoryBean} interface. New methods might be added
 * to this extended interface even in point releases.
 *
 * @author Juergen Hoeller
 * @since 2.0.3
 * @param <T> the bean type
 * @see #isPrototype()
 * @see #isSingleton()
 */
public interface SmartFactoryBean<T> extends FactoryBean<T> {

	/**
	 * Is the object managed by this factory a prototype? That is,
	 * will {@link #getObject()} always return an independent instance?
	 * <p>The prototype status of the FactoryBean itself will generally
	 * be provided by the owning {@link BeanFactory}; usually, it has to be
	 * defined as singleton there.
	 * <p>This method is supposed to strictly check for independent instances;
	 * it should not return {@code true} for scoped objects or other
	 * kinds of non-singleton, non-independent objects. For this reason,
	 * this is not simply the inverted form of {@link #isSingleton()}.
	 * <p>The default implementation returns {@code false}.
	 * @return whether the exposed object is a prototype
	 * @see #getObject()
	 * @see #isSingleton()
	 */
	default boolean isPrototype() {
		return false;
	}

	//一个标准的FactoryBean不需要急于初始化
	//仅在实际访问时调用，即使是在单例对象的情况下也是如此。
	// 从这个方法返回true表明FactoryBean.getObject（）应该急切地调用，
	// 也应该急切地应用后处理器。这在单例对象的情况下可能是有意义的，特别是当后处理器希望在启动时应用时。
	/**
	 * Does this FactoryBean expect eager initialization, that is,
	 * eagerly initialize itself as well as expect eager initialization
	 * of its singleton object (if any)?
	 * <p>A standard FactoryBean is not expected to initialize eagerly:
	 * Its {@link #getObject()} will only be called for actual access, even
	 * in case of a singleton object. Returning {@code true} from this
	 * method suggests that {@link #getObject()} should be called eagerly,
	 * also applying post-processors eagerly. This may make sense in case
	 * of a {@link #isSingleton() singleton} object, in particular if
	 * post-processors expect to be applied on startup.
	 * <p>The default implementation returns {@code false}.
	 * @return whether eager initialization applies
	 * @see org.springframework.beans.factory.config.ConfigurableListableBeanFactory#preInstantiateSingletons()
	 */
	default boolean isEagerInit() {
		return false;
	}

}
