package com.john.kownledge;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/11/13
 */
public class CollectionUtilsDemo {

	public static void main(String[] args) {


		List<String> aliases = new ArrayList<>();
		aliases.add("wonder");
		aliases.add("john");


		Set<String> usedNames = new HashSet<>();
		usedNames.add("wonder1");
		usedNames.add("wonder2");
		usedNames.add("wonder");
		usedNames.add("wonder3");
		usedNames.add("john");
		usedNames.add("wonder4");

		//遍历list中的元素 到set中找到第一个匹配list中的元素的元素
		String foundName = CollectionUtils.findFirstMatch(usedNames, aliases);

		System.out.println(foundName);
	}
}
