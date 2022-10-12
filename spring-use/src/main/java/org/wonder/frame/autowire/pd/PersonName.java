package org.wonder.frame.autowire.pd;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/5/9
 */
public class PersonName {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PersonName{" +
				"value='" + value + '\'' +
				'}';
	}
}
