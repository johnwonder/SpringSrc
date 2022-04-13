/*
 * Copyright 2002-2013 the original author or authors.
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

package org.springframework.aop.framework;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;

import org.springframework.aop.Advisor;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.tests.sample.beans.ITestBean;
import org.springframework.tests.sample.beans.TestBean;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Benchmarks for introductions.
 *
 * NOTE: No assertions!
 *
 * @author Rod Johnson
 * @author Chris Beams
 * @since 2.0
 */
public class IntroductionBenchmarkTests {

	private static final int EXPECTED_COMPARE = 13;

	/** Increase this if you want meaningful results! */
	private static final int INVOCATIONS = 100000;


	@SuppressWarnings("serial")
	public static class SimpleCounterIntroduction extends DelegatingIntroductionInterceptor implements Counter {
		@Override
		public int getCount() {
			return EXPECTED_COMPARE;
		}
	}

	public static interface Counter {
		int getCount();
	}

	@Test
	public void timeManyInvocations() {
		StopWatch sw = new StopWatch();

		TestBean target = new TestBean();
		ProxyFactory pf = new ProxyFactory(target);
		pf.setProxyTargetClass(false);
		pf.addAdvice(new SimpleCounterIntroduction());
		ITestBean proxy = (ITestBean) pf.getProxy();

		Counter counter = (Counter) proxy;

		sw.start(INVOCATIONS + " invocations on proxy, not hitting introduction");
		for (int i = 0; i < INVOCATIONS; i++) {
			proxy.getAge();
		}
		sw.stop();

		sw.start(INVOCATIONS + " invocations on proxy, hitting introduction");
		for (int i = 0; i < INVOCATIONS; i++) {
			counter.getCount();
		}
		sw.stop();

		sw.start(INVOCATIONS + " invocations on target");
		for (int i = 0; i < INVOCATIONS; i++) {
			target.getAge();
		}
		sw.stop();

		System.out.println(sw.prettyPrint());
	}

	@Test
	public void doOther() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Person person = new Person();
		ProxyFactory factory = new ProxyFactory(new Person());
		factory.setProxyTargetClass(false); // 强制私用CGLIB 以保证我们的Person方法也能正常调用

		// 此处采用IntroductionInterceptor 这个引介增强的拦截器
		Advice advice = new SomeInteIntroductionInterceptor();

		// 切点+通知（注意：此处放的是复合切面）
		Advisor advisor = new DefaultIntroductionAdvisor((DynamicIntroductionAdvice) advice, IOtherInte.class);
		//Advisor advisor = new DefaultPointcutAdvisor(cut, advice);
		factory.addAdvisor(advisor);

		IOtherInte otherInte = (IOtherInte) factory.getProxy();
		otherInte.doOther();

		System.out.println("===============================");

		// Person本身自己的方法  也得到了保留
		Person p = (Person) factory.getProxy();

		//Method run = person.getClass().getMethod("run");

		//method.invoke(factory.getProxy(), args);
		//run.invoke(factory.getProxy(), null);
		p.run();
		p.say();
	}

	public class SomeInteIntroductionInterceptor implements IntroductionInterceptor, IOtherInte {
		/**
		 * 判断调用的方法是否为指定类中的方法
		 * 如果Method代表了一个方法 那么调用它的invoke就相当于执行了它代表的这个方法
		 */
		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
				System.out.println("我是引介增强的方法体~~~invoke");
				return invocation.getMethod().invoke(this, invocation.getArguments());
			}
			return invocation.proceed();
		}

		/**
		 * 判断clazz是否为给定接口IOtherBean的实现
		 */
		@Override
		public boolean implementsInterface(Class clazz) {
			return clazz.isAssignableFrom(IOtherInte.class);
		}

		@Override
		public void doOther() {
			System.out.println("给人贴标签 doOther...");
		}
	}

	public interface IOtherInte {
		void doOther();
	}

	public static class  Person {

		void run(){

		}

		void say(){

		}
	}
}
