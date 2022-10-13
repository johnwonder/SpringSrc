package com.john.yaml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public abstract class Node implements NodeOps{

	public Node() {
	}

	public Node(String value, String type, String code) {
		this.value = value;
		this.type = type;
		this.code = code;
	}

	private String value;
	private String type;
	private String code;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void addNode(Node node) {

	}

	@Override
	public void addAllNode(Node... nodes) {

	}

	@Override
	public String toString() {
		return "Node{" +
				"value='" + value + '\'' +
				", type='" + type + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
