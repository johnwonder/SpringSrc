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

package org.springframework.context.support;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

//AbstractRefreshableApplicationContext的子类
//添加指定配置文件路径的常用处理
//还实现了 BeanNameAware和 InitializingBean接口
/**
 * {@link AbstractRefreshableApplicationContext} subclass that adds common handling
 * of specified config locations. Serves as base class for XML-based application
 * context implementations such as {@link ClassPathXmlApplicationContext} and
 * {@link FileSystemXmlApplicationContext}, as well as
 * {@link org.springframework.web.context.support.XmlWebApplicationContext}.
 *
 * @author Juergen Hoeller
 * @since 2.5.2
 * @see #setConfigLocation
 * @see #setConfigLocations
 * @see #getDefaultConfigLocations
 */

//https://blog.csdn.net/qq_33567641/article/details/80986235
//给 ClassPathXmlApplicationContext  和 FileSystemXmlApplicationContext 还有XmlWebApplicationContext 提供服务的
public abstract class AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext
		implements BeanNameAware, InitializingBean {

	@Nullable
	private String[] configLocations;

	private boolean setIdCalled = false;


	/**
	 * Create a new AbstractRefreshableConfigApplicationContext with no parent.
	 */
	public AbstractRefreshableConfigApplicationContext() {
	}

	/**
	 * Create a new AbstractRefreshableConfigApplicationContext with the given parent context.
	 * @param parent the parent context
	 */
	public AbstractRefreshableConfigApplicationContext(@Nullable ApplicationContext parent) {
		super(parent);
	}


	/**
	 * Set the config locations for this application context in init-param style,
	 * i.e. with distinct locations separated by commas, semicolons or whitespace.（分号或者空格)
	 * <p>If not set, the implementation may use a default as appropriate.
	 */
	public void setConfigLocation(String location) {
		//支持 location 以分号后者空格来分割 比如 "config1.xml,config2.xml"
		//ConfigurableApplicationContext 定义 CONFIG_LOCATION_DELIMITERS
		//String CONFIG_LOCATION_DELIMITERS = ",; \t\n";
		setConfigLocations(StringUtils.tokenizeToStringArray(location, CONFIG_LOCATION_DELIMITERS));
	}

	//java1.5就引入了可变参数
	//https://www.cnblogs.com/Beansczm/p/9508326.html
	/**
	 * Set the config locations for this application context.
	 * <p>If not set, the implementation may use a default as appropriate.
	 */
	public void setConfigLocations(@Nullable String... locations) {

		if (locations != null) {
			//遍历locations中的变量是否为null
			Assert.noNullElements(locations, "Config locations must not be null");


			this.configLocations = new String[locations.length];
			for (int i = 0; i < locations.length; i++) {
				//调用抽象父类 AbstractRefreshableConfigApplicationContext 的  resolvePath方法
				this.configLocations[i] = resolvePath(locations[i]).trim();
			}
		}
		else {
			this.configLocations = null;
		}
	}

	//子类可以重写这个方法：提供 资源路径的集合
	//
	/**
	 * Return an array of resource locations, referring to the XML bean definition
	 * files that this context should be built with. Can also include location
	 * patterns, which will get resolved via a ResourcePatternResolver.
	 * <p>The default implementation returns {@code null}. Subclasses can override
	 * this to provide a set of resource locations to load bean definitions from.
	 * @return an array of resource locations, or {@code null} if none
	 * @see #getResources
	 * @see #getResourcePatternResolver
	 */
	@Nullable
	protected String[] getConfigLocations() {
		return (this.configLocations != null ? this.configLocations : getDefaultConfigLocations());
	}

	//返回默认的配置路径。 如果没有指定 显示的配置路径
	/**
	 * Return the default config locations to use, for the case where no
	 * explicit config locations have been specified.
	 * <p>The default implementation returns {@code null},
	 * requiring explicit config locations.
	 * @return an array of default config locations, if any
	 * @see #setConfigLocations
	 */
	@Nullable
	protected String[] getDefaultConfigLocations() {
		return null;
	}

	/**
	 * Resolve the given path, replacing placeholders with corresponding
	 * environment property values if necessary. Applied to config locations.
	 * @param path the original file path
	 * @return the resolved file path
	 * @see org.springframework.core.env.Environment#resolveRequiredPlaceholders(String)
	 */
	protected String resolvePath(String path) {
		//通过当前环境去 解析 必要的占位符
		return getEnvironment().resolveRequiredPlaceholders(path);
	}


	@Override
	public void setId(String id) {
		super.setId(id);
		this.setIdCalled = true;
	}

	// 对于上下文实例本身定义为bean的情况。会设置id 为 bean 名称
	/**
	 * Sets the id of this context to the bean name by default,
	 * for cases where the context instance is itself defined as a bean.
	 */
	@Override
	public void setBeanName(String name) {
		if (!this.setIdCalled) {
			super.setId(name);
			setDisplayName("ApplicationContext '" + name + "'");
		}
	}

	/**
	 * Triggers {@link #refresh()} if not refreshed in the concrete context's
	 * constructor already.
	 */
	@Override
	public void afterPropertiesSet() {
		if (!isActive()) {
			refresh();
		}
	}

}
