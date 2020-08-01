package com.john.aop;

//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
//@Aspect
class Broker {

	//@Before("execution(* com.john.aop.Landlord.service())")
	public void before(){
		System.out.println("带租客看房");
		System.out.println("谈价格");
	}

	//@After("execution(* com.john.aop.Landlord.service())")
	public void after(){
		System.out.println("交钥匙");
	}
}