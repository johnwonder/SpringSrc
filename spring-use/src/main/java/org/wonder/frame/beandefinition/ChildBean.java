package org.wonder.frame.beandefinition;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/4/11
 */
public class ChildBean {

	private String id;
	private String name;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "ChildBean{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
