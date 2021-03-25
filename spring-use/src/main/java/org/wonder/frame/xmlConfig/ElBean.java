package org.wonder.frame.xmlConfig;

import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/3/17
 */
public class ElBean {


	private String age;

	private Map<String, String> maps;

	private List<String> lists;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "ElBean{" +
				"age='" + age + '\'' +
				", maps=" + maps +
				", lists=" + lists +
				'}';
	}
}
