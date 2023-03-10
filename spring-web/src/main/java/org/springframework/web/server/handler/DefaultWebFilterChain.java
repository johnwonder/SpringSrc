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

package org.springframework.web.server.handler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.lang.Nullable;
import reactor.core.publisher.Mono;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.WebHandler;

/**
 * Default implementation of {@link WebFilterChain}.
 *
 * @author Rossen Stoyanchev
 * @since 5.0
 */
public class DefaultWebFilterChain implements WebFilterChain {

	private final List<WebFilter> filters;

	private final WebHandler handler;

	private final int index;

	//5.1开始改成这种形式
//	public DefaultWebFilterChain(WebHandler handler, List<WebFilter> filters) {
//		Assert.notNull(handler, "WebHandler is required");
//		this.allFilters = Collections.unmodifiableList(filters);
//		this.handler = handler;
//		DefaultWebFilterChain chain = initChain(filters, handler);
//		this.currentFilter = chain.currentFilter;
//		this.chain = chain.chain;
//	}
//
	//chain形成了链表
//	private static DefaultWebFilterChain initChain(List<WebFilter> filters, WebHandler handler) {
//		DefaultWebFilterChain chain = new DefaultWebFilterChain(filters, handler, null, null);
//		ListIterator<? extends WebFilter> iterator = filters.listIterator(filters.size());
//		while (iterator.hasPrevious()) {
//			chain = new DefaultWebFilterChain(filters, handler, iterator.previous(), chain);
//		}
//		return chain;
//	}

//	private DefaultWebFilterChain(List<WebFilter> allFilters, WebHandler handler,
//								  @Nullable WebFilter currentFilter, @Nullable DefaultWebFilterChain chain) {
//
//		this.allFilters = allFilters;
//		this.currentFilter = currentFilter;
//		this.handler = handler;
//		this.chain = chain;
//	}

	public DefaultWebFilterChain(WebHandler handler, WebFilter... filters) {
		Assert.notNull(handler, "WebHandler is required");
		this.filters = ObjectUtils.isEmpty(filters) ? Collections.emptyList() : Arrays.asList(filters);
		this.handler = handler;
		this.index = 0;
	}

	private DefaultWebFilterChain(DefaultWebFilterChain parent, int index) {
		this.filters = parent.getFilters();
		this.handler = parent.getHandler();
		this.index = index;
	}


	public List<WebFilter> getFilters() {
		return this.filters;
	}

	public WebHandler getHandler() {
		return this.handler;
	}

//	@Override
//	public Mono<Void> filter(ServerWebExchange exchange) {
	//相当于调用下一个filter
//		return Mono.defer(() ->
//				this.currentFilter != null && this.chain != null ?
//						invokeFilter(this.currentFilter, this.chain, exchange) :
//						this.handler.handle(exchange));
//	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange) {
		//https://blog.csdn.net/john1337/article/details/104205774
		return Mono.defer(() -> {
			//遍历过滤器
			if (this.index < this.filters.size()) {
				WebFilter filter = this.filters.get(this.index);
				WebFilterChain chain = new DefaultWebFilterChain(this, this.index + 1);
				return filter.filter(exchange, chain);
			}
			else {
				return this.handler.handle(exchange);
			}
		});
	}

}
