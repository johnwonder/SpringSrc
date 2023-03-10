/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.http.server.reactive;

import java.net.URISyntaxException;
import java.util.function.BiFunction;

import io.netty.handler.codec.http.HttpResponseStatus;
import org.apache.commons.logging.Log;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

//https://blog.csdn.net/ssehs/article/details/120927767
//https://juejin.cn/post/6844903784309587981
//https://blog.csdn.net/cunfu6353/article/details/107228601/
//Reactor
//https://www.infoq.com/articles/Servlet-and-Reactive-Stacks-Spring-Framework-5/?topicPageSponsorship=c1246725-b0a7-43a6-9ef9-68102c8d48e1
/**
 * Adapt {@link HttpHandler} to the Reactor Netty channel handling function.
 *
 * @author Stephane Maldini
 * @author Rossen Stoyanchev
 * @since 5.0
 */
public class ReactorHttpHandlerAdapter implements BiFunction<HttpServerRequest, HttpServerResponse, Mono<Void>> {

	private static final Log logger = HttpLogging.forLogName(ReactorHttpHandlerAdapter.class);


	private final HttpHandler httpHandler;


	//https://zhuanlan.zhihu.com/p/461779410
	public ReactorHttpHandlerAdapter(HttpHandler httpHandler) {
		Assert.notNull(httpHandler, "HttpHandler must not be null");
		this.httpHandler = httpHandler;
	}


	//https://blog.csdn.net/wenhaipan/article/details/103643033
	//collectMap
	@Override
	public Mono<Void> apply(HttpServerRequest reactorRequest, HttpServerResponse reactorResponse) {
		NettyDataBufferFactory bufferFactory = new NettyDataBufferFactory(reactorResponse.alloc());
		try {
			ReactorServerHttpRequest request = new ReactorServerHttpRequest(reactorRequest, bufferFactory);
			ServerHttpResponse response = new ReactorServerHttpResponse(reactorResponse, bufferFactory);

			if (request.getMethod() == HttpMethod.HEAD) {
				response = new HttpHeadResponseDecorator(response);
			}

			//交给httpHandler执行
			return this.httpHandler.handle(request, response)
					.doOnError(ex -> logger.trace(request.getLogPrefix() + "Failed to complete: " + ex.getMessage()))
					.doOnSuccess(aVoid -> logger.trace(request.getLogPrefix() + "Handling completed"));
		}
		catch (URISyntaxException ex) {
			if (logger.isDebugEnabled()) {
				logger.debug("Failed to get request URI: " + ex.getMessage());
			}
			reactorResponse.status(HttpResponseStatus.BAD_REQUEST);
			return Mono.empty();
		}
	}

}
