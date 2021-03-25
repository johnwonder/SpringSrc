package org.wonder.frame.beanDefinitionBuilder;

import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/2/2
 */
public class Person {

	private String name;
	private String age;

	private Map<String,String> posts;

	private List<String> ranks;


	public Map<String, String> getPosts() {
		return posts;
	}

	public void setPosts(Map<String, String> posts) {
		this.posts = posts;
	}

	public List<String> getRanks() {
		return ranks;
	}

	public void setRanks(List<String> ranks) {
		this.ranks = ranks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				", posts=" + posts +
				", ranks=" + ranks +
				'}';
	}
}
