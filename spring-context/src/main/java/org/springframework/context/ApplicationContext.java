/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

//给应用提供配置的核心接口，
// 当应用运行的时候这个上下文是只读的，但是实现支持的话 上下文有可能重新加载。

//一个应用上下文提供如下功能：

//1.可以访问应用内部组件，通过继承ListableBeanFactory 接口

//2.可以加载文件资源，通过继承ResourceLoader接口

//3.可以发布事件给注册的监听器，通过继承自ApplicationEventPublisher接口

//4.支持国际化，通过继承自MessageSource接口

//5.可能继承自一个父的上下文, 子上下文内的bean定义通常是优先的
//比如 每一个servlet都有自己的子上下文 独立于其他的servlet

//6.除了标准的BeanFactory生命周期外，应用上下文 会监测和调用实现ApplicationContextAware接口的bean
/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 *
 *
 * <p>An ApplicationContext provides:
 * <ul>
 * <li>Bean factory methods for accessing application components.
 * Inherited from {@link org.springframework.beans.factory.ListableBeanFactory}.
 *
 * <li>The ability to load file resources in a generic fashion.
 * Inherited from the {@link org.springframework.core.io.ResourceLoader} interface.
 * <li>The ability to publish events to registered listeners.
 * Inherited from the {@link ApplicationEventPublisher} interface.
 * <li>The ability to resolve messages, supporting internationalization.
 * Inherited from the {@link MessageSource} interface.
 * <li>Inheritance from a parent context. Definitions in a descendant context
 * will always take priority. This means, for example, that a single parent
 * context can be used by an entire web application, while each servlet has
 * its own child context that is independent of that of any other servlet.
 * 每一个servlet都有自己都子上下文 独立于其他的servlet
 * </ul>
 *
 * <p>In addition to standard {@link org.springframework.beans.factory.BeanFactory}
 * lifecycle capabilities, ApplicationContext implementations detect and invoke
 * {@link ApplicationContextAware} beans as well as {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} and {@link MessageSourceAware} beans.
 * 除了标准的生命周期能力，应用上下文的实现 发现和调用 resourceLoaderAware
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	//1.0就继承了ListableBeanFactory,ListableBeanFactory又继承了BeanFactory
	//1.2.9还没继承EnvironmentCapable接口
	/**
	 * Return the unique id of this application context.
	 * @return the unique id of the context, or {@code null} if none
	 */
	@Nullable
	String getId();

	/**
	 * Return a name for the deployed application that this context belongs to.
	 * @return a name for the deployed application, or the empty String by default
	 */
	String getApplicationName();

	//v1.0就开始有了，
	/**
	 * Return a friendly name for this context.
	 * @return a display name for this context (never {@code null})
	 */
	String getDisplayName();

	/**
	 * Return the timestamp when this context was first loaded.
	 * @return the timestamp (ms) when this context was first loaded
	 */
	long getStartupDate();

	//v1.0就开始有了，
	/**
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.
	 * @return the parent context, or {@code null} if there is no parent
	 */
	@Nullable
	ApplicationContext getParent();

	//暴露 AutowireCapableBeanFactory的功能

	//可以在应用上下文之外 初始化bean实例
	//可以把bean的生命周期 应用到这些bean上面。
	//AutowireCapableBeanFactory 提供了  configureBean等配置bean的方法

	//ConfigurableApplicationContext 暴露了ConfigurableListableBeanFactory
	//因为ConfigurableListableBeanFactory 继承自AutowireCapableBeanFactory 接口
	//所以同时也可以访问AutowireCapableBeanFactory了

	//本方法主要用作ApplicationContext接口上的一种方便、特定的工具

	//4.2版本起，该方法在应用上下文关闭的情况下会抛出异常
	//在当前的Spring框架版本中，只有可刷新的应用程序上下文才有这种行为
	//从4.2开始，所有应用程序上下文实现都需要遵守

	//在refresh调用前不会持有一个自动装配的bean工厂
	/**
	 * 对正在初始化的bean实例应用Spring bean生命周期（全部或部分）
	 * Expose AutowireCapableBeanFactory functionality for this context.
	 * <p>This is not typically used by application code, except for the purpose of
	 * initializing bean instances that live outside of the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * <p>Alternatively, the internal BeanFactory exposed by the
	 * {@link ConfigurableApplicationContext} interface offers access to the
	 * {@link AutowireCapableBeanFactory} interface too. The present method mainly
	 * serves as a convenient, specific facility on the ApplicationContext interface.
	 * <p><b>NOTE: As of 4.2, this method will consistently throw IllegalStateException
	 * after the application context has been closed.</b> In current Spring Framework
	 * versions, only refreshable application contexts behave that way; as of 4.2,
	 * all application context implementations will be required to comply.
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
