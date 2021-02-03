package com.john.resolveType;

import java.util.List;
import java.util.Map;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/19
 */
public class GenricInjectTest {


	private Service<String, String> abService;

	private Service<String, Double> cdService;

	private List<List<Integer>> list;

	private Map<String, Map<String, Integer>> map;

	private List<String>[] array;

	public GenricInjectTest() {
	}


}
