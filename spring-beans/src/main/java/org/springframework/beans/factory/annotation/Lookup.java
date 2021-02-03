/*
 * Copyright 2002-2015 the original author or authors.
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

package org.springframework.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//4.1才引入
//https://www.oschina.net/news/55007/spring-framework-4-1-ga-is-here!?p=1
//Annotated @Lookup methods with support for provided constructor arguments
//https://blog.csdn.net/weixin_45386351/article/details/105059902
//todo https://www.jianshu.com/p/fc574881e3a2 可以再看看 2021-1-15
//表示“lookup”方法的注解，由容器重写以将它们重定向回BeanFactory进行getBean调用
//这本质上是基于注释的XML lookup method属性版本，产生相同的运行时安排。

//目标bean的解析可以基于返回类型（getBean（Class））或建议的bean名称（getBean（String）），在这两种情况下，都将方法的参数传递给getBean调用，以便将它们作为目标工厂方法参数或构造函数参数应用

//这种查找方法可以有默认的（存根）实现，这些实现将被容器替换，或者可以声明为抽象的，以便容器在运行时填充它们。
// 在这两种情况下，容器都将通过CGLIB生成方法的包含类的运行时子类，
// 这就是为什么这样的查找方法只能在容器通过常规构造函数实例化的bean上工作：
// 即，在工厂方法返回的bean上，查找方法不能被替换，在工厂方法中，我们不能动态地为他们提供子类

//典型Spring配置场景中的具体限制：当与组件扫描或任何其他过滤抽象bean的机制一起使用时，提供查找方法的存根实现，以便能够将它们声明为具体类。
// 请记住，在配置类中从@Bean方法返回的Bean上，查找方法不起作用；您必须求助于
// @Inject  Provider<TargetBean>或类似的方法。
/**
 * An annotation that indicates 'lookup' methods, to be overridden by the container
 * to redirect them back to the {@link org.springframework.beans.factory.BeanFactory}
 * for a {@code getBean} call. This is essentially an annotation-based version of the
 * XML {@code lookup-method} attribute, resulting in the same runtime arrangement.
 *
 * <p>The resolution of the target bean can either be based on the return type
 * ({@code getBean(Class)}) or on a suggested bean name ({@code getBean(String)}),
 * in both cases passing the method's arguments to the {@code getBean} call
 * for applying them as target factory method arguments or constructor arguments.
 *
 * <p>Such lookup methods can have default (stub) implementations that will simply
 * get replaced by the container, or they can be declared as abstract - for the
 * container to fill them in at runtime. In both cases, the container will generate
 * runtime subclasses of the method's containing class via CGLIB, which is why such
 * lookup methods can only work on beans that the container instantiates through
 * regular constructors: i.e. lookup methods cannot get replaced on beans returned
 * from factory methods where we cannot dynamically provide a subclass for them.
 *
 * <p><b>Concrete limitations in typical Spring configuration scenarios:</b>
 * When used with component scanning or any other mechanism that filters out abstract
 * beans, provide stub implementations of your lookup methods to be able to declare
 * them as concrete classes. And please remember that lookup methods won't work on
 * beans returned from {@code @Bean} methods in configuration classes; you'll have
 * to resort to {@code @Inject Provider<TargetBean>} or the like instead.
 *
 * @author Juergen Hoeller
 * @since 4.1
 * @see org.springframework.beans.factory.BeanFactory#getBean(Class, Object...)
 * @see org.springframework.beans.factory.BeanFactory#getBean(String, Object...)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lookup {

	//如果指定 就代表根据Bean名称查找，不指定就根据方法返回类型查找Bean.
	/**
	 * This annotation attribute may suggest a target bean name to look up.
	 * If not specified, the target bean will be resolved based on the
	 * annotated method's return type declaration.
	 */
	String value() default "";

}
