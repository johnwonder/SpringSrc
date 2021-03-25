/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.util;

import org.springframework.lang.Nullable;

/**
 * Utility methods for simple pattern matching, in particular for
 * Spring's typical "xxx*", "*xxx" and "*xxx*" pattern styles.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
public abstract class PatternMatchUtils {

	/**
	 * Match a String against the given pattern, supporting the following simple
	 * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
	 * arbitrary number of pattern parts), as well as direct equality.
	 * @param pattern the pattern to match against
	 * @param str the String to match
	 * @return whether the String matches the given pattern
	 */
	public static boolean simpleMatch(@Nullable String pattern, @Nullable String str) {
		//pattern 匹配模式为空 或者待匹配字符串为空就返回false
		if (pattern == null || str == null) {
			return false;
		}
		//找到第一个* 在匹配模式字符串中的的索引
		int firstIndex = pattern.indexOf('*');
		if (firstIndex == -1) {
			//索引为空的情况下就代表 模式字符串要和待匹配字符串相等。
			return pattern.equals(str);
		}
		//*在第一位
		if (firstIndex == 0) {
			//*在第一位 且匹配模式字符串长度为1 那就直接返回true ，比如 *
			if (pattern.length() == 1) {
				return true;
			}
			//找到下一个*的起始位置
			int nextIndex = pattern.indexOf('*', firstIndex + 1);
			if (nextIndex == -1) {
				//如果没有*了，就判断 待匹配的字符串是否是以pattern结尾的。
				//比如*service   Aservice就满足这种情况
				return str.endsWith(pattern.substring(1));
			}
			//截取第一个* 和之后一个* 之间的字符串
			String part = pattern.substring(1, nextIndex);
			if (part.isEmpty()) {
				return simpleMatch(pattern.substring(nextIndex), str);
			}
			//str 是指待匹配的字符
			int partIndex = str.indexOf(part);
			while (partIndex != -1) {
				if (simpleMatch(pattern.substring(nextIndex), str.substring(partIndex + part.length()))) {
					return true;
				}
				//从partIndex+1 开始计算part的索引
				partIndex = str.indexOf(part, partIndex + 1);
			}
			return false;
		}
		//待匹配字符串的长度比 第一个*的索引 大或者相等的情况下
		//截取模式字符串 0 到 第一个*号之间的字符串 ，截取 待匹配字符串 0 到 第一个*号之间的字符串 对比
		//如果相等 ，再截取 模式字符串  第一个*号之后的字符串 和 待匹配 字符串  第一个*号之后的字符串 去做匹配
		return (str.length() >= firstIndex &&
				pattern.substring(0, firstIndex).equals(str.substring(0, firstIndex)) &&
				simpleMatch(pattern.substring(firstIndex), str.substring(firstIndex)));
	}

	/**
	 * Match a String against the given patterns, supporting the following simple
	 * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
	 * arbitrary number of pattern parts), as well as direct equality.
	 * @param patterns the patterns to match against
	 * @param str the String to match
	 * @return whether the String matches any of the given patterns
	 */
	public static boolean simpleMatch(@Nullable String[] patterns, String str) {
		if (patterns != null) {
			for (String pattern : patterns) {
				if (simpleMatch(pattern, str)) {
					return true;
				}
			}
		}
		return false;
	}

}
