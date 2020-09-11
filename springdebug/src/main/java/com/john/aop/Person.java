package com.john.aop;

import org.springframework.stereotype.Component;

/**
 * @Description: SpringSrc
 * @Author: zhangjiong
 * @Date: 2020/4/14
 */
@Component
public class Person {
	private int id;
	private String firstName;
	private String lastName;

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(){

	}

	public int getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }

	public void setId(int id) { this.id = id; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }

	@Override
	public String toString() { return "Person [" + id + ", " + firstName + " " + lastName + "]"; }

	public static void main(String[] args) {
		Person albert = new Person(1, "Albert", "Camus");
		Person audrey = new Person(2, "Audrey", "Hepburn");
		System.out.println(albert);
		System.out.println(audrey);
		System.out.println();
		albert.setId(8);
		albert.setLastName("Einstein");
		audrey.setId(9);
		audrey.setLastName("Tautou");
		System.out.println();
		System.out.println(albert);
		System.out.println(audrey);
	}
}
