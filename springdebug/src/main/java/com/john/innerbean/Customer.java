package com.john.innerbean;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/31
 */
public class Customer
{
	private Person person;

//	public Customer(Person person) {
//		this.person = person;
//	}

	public Customer(){

	}

	//	public Customer(Person person) {
//		this.person = person;
//	}
//
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + "]";
	}
}
