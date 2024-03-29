package com.john.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//	//1.使用InvocationHandler接口创建代理类的处理器
//	//2.使用Proxy类的静态方法newProxyInstance直接创建代理对象
//	//3.使用代理对象
/**
 * @Description: jdk 接口的动态代理
 * @Author: johnwonder
 * @Date: 2020/7/9
 */
public class ProxyFactory<T> {

	//维护一个目标对象
	private Object target;
	private Class<T> targetInterface;
	public ProxyFactory(Object target){
		this.target=target;
	}

	public ProxyFactory(Class<T> targetInterface){
		this.targetInterface=targetInterface;
	}


	//给目标对象生成代理对象
	//https://blog.csdn.net/a837199685/article/details/68930987
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				(proxy, method, args) -> {
					System.out.println("开始事务2");
					//运用反射执行目标对象方法
					Object returnValue = method.invoke(target, args);
					System.out.println("提交事务2");
					return returnValue;
				}
		);
	}

	//https://ytao.top/2020/04/05/20-java-proxy/
	//https://blog.csdn.net/jiankunking/article/details/52143504
	//https://blog.csdn.net/a907691592/article/details/95354063
	public T getProxyInterface(){
		return (T)Proxy.newProxyInstance(
				targetInterface.getClassLoader(),
				new Class[]{targetInterface},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开始事务2");
						//运用反射执行目标对象方法
						//Object returnValue = method.invoke(target, args);
						System.out.println("提交事务2");
						return null;
					}
				}
		);
	}
}
