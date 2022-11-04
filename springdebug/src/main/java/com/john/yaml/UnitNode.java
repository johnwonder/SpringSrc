package com.john.yaml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 机构类
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public class UnitNode extends Node {

	public UnitNode() {
	}

	private List<UnitNode> children;
	private List<EmployeeNode> employees;
	private String abbrev;

	public UnitNode(String id, String value, String abbrev, String type, String code , String source) {
		super(id,value, type, code,source);
		this.abbrev =abbrev;
	}

	public void setChildren(List<UnitNode> children) {
		this.children = children;
	}

	public void setEmployees(List<EmployeeNode> employees) {
		this.employees = employees;
	}

	public List<EmployeeNode> getEmployees() {
		return employees;
	}

	public List<UnitNode> getChildren() {
		return children;
	}

	public String getAbbrev() {
		return abbrev;
	}

	/**
	 * 简称
	 * @param abbrev
	 */
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	@Override
	public void addNode(Node node){

		if(node instanceof EmployeeNode){
			if(this.employees == null)
				this.employees = new ArrayList<>();

			EmployeeNode employyee = (EmployeeNode)node;
			this.employees.add(employyee);
			return;
		}
		if(this.children == null)
			this.children = new ArrayList<>();

		UnitNode unit = (UnitNode)node;
		this.children.add(unit);

	}
	@Override
	public void addAllNode(Node... nodes) {

		if(nodes == null)
			return;

		for (Node node : nodes) {
			addNode(node);
		}

	}
}
