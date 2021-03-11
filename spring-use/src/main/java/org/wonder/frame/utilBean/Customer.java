package org.wonder.frame.utilBean;

import java.io.Serializable;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/9
 */
class Customer implements Serializable {

	static final long serialVersionUID = 1L;

	private int id;

	private String name;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

