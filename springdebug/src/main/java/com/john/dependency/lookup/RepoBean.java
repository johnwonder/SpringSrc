package com.john.dependency.lookup;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/15
 */
//跟@Component注解的
@Repository("lookup")
@Lazy
public class RepoBean  {

//	public LookupBean() {
//	}
	//标注为lazy 延迟初始化的话可以传入参数
	//因为getBean的时候 传入的args参数 只在创建新实例的时候 会起作用
	public RepoBean(String args) {

		System.out.println("构造函数初始化 "+ args);
	}

	@Override
	public String toString() {
		return  "lookup success" ;
	}
}
