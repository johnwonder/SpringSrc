package com.john.yaml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 机构类
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public class UnitNode extends Node  {

	private List<Node> children;
	private List<Node> employees;

	public UnitNode() {
		super();
	}

	public UnitNode(String value, String type, String code) {
		super(value, type, code);
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public void setEmployees(List<Node> employees) {
		this.employees = employees;
	}

	public List<Node> getEmployees() {
		return employees;
	}

	public List<Node> getChildren() {
		return children;
	}

	@Override
	public void addNode(Node node){

		if("U".equals(node.getType())){
			if(this.employees == null)
				this.employees = new ArrayList<>();
			this.employees.add(node);
			return;
		}
		if(this.children == null)
			this.children = new ArrayList<>();
		this.children.add(node);

	}

	@Override
	public void addAllNode(Node... nodes) {

		if(nodes == null)
			return;

		for (Node node : nodes) {
			 addNode(node);
		}

	}

	@Override
	public String toString() {
		return "UnitNode{" +
				"children=" + children +
				", employees=" + employees +
				'}';
	}
}
