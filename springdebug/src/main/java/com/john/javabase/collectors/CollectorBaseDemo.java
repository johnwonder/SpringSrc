package com.john.javabase.collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/5/21
 */
public class CollectorBaseDemo {

	public static void main(String[] args) {

		removeCollectElements();

		collectorsToMap();
	}

	/**
	 * 利用Predicate来删除元素
	 * https://www.felord.cn/remove-element-from-collection.html
	 */
	private static void removeCollectElements(){


		List<String> servers = new ArrayList<>();
		servers.add("Felordcn");
		servers.add("Tomcat");
		servers.add("Jetty");
		servers.add("Undertow");
		servers.add("Resin");

		servers.removeIf(s-> s.startsWith("F"));

		System.out.println(servers);
	}

	/**
	 * Java8使用Collectors.toMap的坑
	 * https://mp.weixin.qq.com/s/wUEBJWhodwBsJdVaQYa0JA
	 */
	static void collectorsToMap(){
		List<Answer> answerList = new ArrayList<>();
		answerList.add(new Answer(1, true));
		answerList.add(new Answer(2, true));
		answerList.add(new Answer(3, null));


		//报错
//		Map<Integer, Boolean> answerMap =
//				answerList
//						.stream()
//						.collect(Collectors.toMap(Answer::getId, Answer::getAnswer));

		//解决方案一
		//Map<Integer, Boolean> answerMap = answerList.stream().collect(LinkedHashMap::new, (m, v) -> m.put(v.getId(), v.getAnswer()), LinkedHashMap::putAll);

		//解决方案二
		Map<Integer, Boolean> answerMap = new HashMap<>();
		for (Answer answer : answerList) {
			answerMap.put(answer.getId(), answer.getAnswer());
		}

		System.out.println(answerMap);
	}

	static  class Answer {
		private int id;

		private Boolean answer;

		Answer() {
		}

		Answer(int id, Boolean answer) {
			this.id = id;
			this.answer = answer;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Boolean getAnswer() {
			return answer;
		}

		public void setAnswer(Boolean answer) {
			this.answer = answer;
		}
	}
}
