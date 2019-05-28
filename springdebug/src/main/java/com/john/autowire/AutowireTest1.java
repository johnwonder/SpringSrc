package com.john.autowire;

public class AutowireTest1 {

	private  AutowireTest2 autowireTest2;

	public AutowireTest2 getAutowireTest2() {
		return autowireTest2;
	}

	public void setAutowireTest2(AutowireTest2 autowireTest2) {
		this.autowireTest2 = autowireTest2;
	}
}
