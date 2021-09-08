package com.john.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/7/9
 */
public class Test {

	//https://blog.csdn.net/psd0503/article/details/107116881/
	public static void main(String[] args) {
		// 设置这个属性，将代理类的字节码文件生成到F盘的code目录下
		//System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zhangjiong/cglibcode");
		//实例化一个增强器，也就是cglib中的一个class generator
		Enhancer eh = new Enhancer();
		//设置目标类
		eh.setSuperclass(Target.class);
		// 设置拦截对象
		//eh.setCallback(new Interceptor());

		eh.setCallbacks(new Callback[]{new ClassInterceptor(), NoOp.INSTANCE});

		//设置callbackFilter
		eh.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				if(method.getName().equals("g"))
					// 这里返回的是上面定义的callback数组的下标，0就是我们的Interceptor对象，1是内置的NoOp对象，代表不做任何操作
					return 0;
				else return 1;
			}
		});
		// 生成代理类并返回一个实例
		Target t = (Target) eh.create();
		t.f();
		t.g();


		TestInterfaceCGLib testCGLib = new TestInterfaceCGLib();
		TestInterface o = (TestInterface) testCGLib.getInstance(TestInterface.class);
		System.out.println(o.getHelloWorld());

	}
}
