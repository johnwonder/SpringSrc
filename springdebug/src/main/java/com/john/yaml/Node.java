package com.john.yaml;

/**
 * @Description: 抽象节点
 * @Author: johnwonder
 * @Date: 2022/10/13
 */
public abstract class Node implements NodeOps {

	public Node() {
	}

	public Node(String id, String value, String type, String code, String source) {
		this.id =id;
		this.value = value;
		this.type = type;
		this.code = code;
		this.source = source;

	}

	/**
	 * 名称
	 */
	private String value;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 主键
	 */
	private String id;


	/**
     * 数据来源
	 */
	private String source;
	public String getValue() {
		return value;
	}

	/**
	 * 名称
	 * @param value
	 */
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

	/**
     * 编码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	/**
     * 主键
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public void addNode(Node node) {

	}

	@Override
	public void addAllNode(Node... nodes) {

	}
}
