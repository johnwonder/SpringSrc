package com.john.xmlconfig;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class IdRefParent {

	private IdRefChild child;

	@Override
	public String toString() {
		return "IdRefParent{" +
				"child=" + child +
				'}';
	}

	public void setChild(IdRefChild child) {


		this.child = child;
	}
}
