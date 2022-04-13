/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.cache;

import java.util.Collection;

import org.springframework.lang.Nullable;

//就像Spring Framework中的其他服务一样，缓存服务是一种抽象（不是缓存实现），需要使用实际存储来存储缓存数据 - 也就是说，抽象使开发人员不必编写缓存逻辑 但不提供实际的存储。 这种抽象由org.springframework.cache.Cache和org.springframework.cache.CacheManager接口实现。

//原文链接：https://blog.csdn.net/niugang0920/article/details/89173923

//https://www.cnblogs.com/top-housekeeper/p/11865399.html
/**
 * Spring's central cache manager SPI.
 * Allows for retrieving named {@link Cache} regions.
 *
 * @author Costin Leau （https://github.com/costin/） 去elastic了
 * //https://blog.csdn.net/joeyon1985/article/details/41894267
 * @since 3.1
 */
public interface CacheManager {

	/**
	 * Return the cache associated with the given name.
	 * @param name the cache identifier (must not be {@code null})
	 * @return the associated cache, or {@code null} if none found
	 */
	@Nullable
	Cache getCache(String name);

	/**
	 * Return a collection of the cache names known by this manager.
	 * @return the names of all caches known by the cache manager
	 */
	Collection<String> getCacheNames();

}
