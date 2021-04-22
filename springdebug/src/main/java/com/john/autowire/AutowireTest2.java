package com.john.autowire;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
public class AutowireTest2 {

	public AutowireTest2() {
		System.out.println("test2 init");
	}

//	@Override
//	public String toString() {
//		return "AutowireTest2{}";
//	}
}
