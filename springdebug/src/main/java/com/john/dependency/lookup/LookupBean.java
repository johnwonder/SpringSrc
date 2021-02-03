package com.john.dependency.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/15
 */
@Component("lookup")
@Lazy
public class LookupBean implements ILookupBean {

//	public LookupBean() {
//	}
	//标注为lazy 延迟初始化的话可以传入参数
	//因为getBean的时候 传入的args参数 只在创建新实例的时候 会起作用
	public LookupBean(String args) {

		System.out.println("构造函数初始化 "+ args);
	}

	@Override
	public String toString() {
		return  "lookup success" ;
	}
}
