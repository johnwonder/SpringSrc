/*
 * Copyright 2002-2007 the original author or authors.
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

package org.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

//在Spring中，为目标对象添加新的属性和行为必须声明相应的接口以及相应的实现。
// 这样，再通过特定的拦截器将新的接口定义以及实现类中的逻辑附加到目标对象上。然后，目标对象（确切的说，是目标对象的代理对象）就拥有了新的状态和行为
/**
 * Subinterface of AOP Alliance MethodInterceptor that allows additional interfaces
 * to be implemented by the interceptor, and available via a proxy using that
 * interceptor. This is a fundamental AOP concept called <b>introduction</b>.
 *
 * <p>Introductions are often <b>mixins</b>, enabling the building of composite
 * objects that can achieve many of the goals of multiple inheritance in Java.
 *
 * @author Rod Johnson
 * @see DynamicIntroductionAdvice
 */
public interface IntroductionInterceptor extends MethodInterceptor, DynamicIntroductionAdvice {
	//https://blog.csdn.net/f641385712/article/details/89303088
}
