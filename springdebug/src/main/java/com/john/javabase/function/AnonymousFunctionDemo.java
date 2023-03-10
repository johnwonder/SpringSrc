package com.john.javabase.function;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.function.Function;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/3/23
 */
public class AnonymousFunctionDemo {

	//https://www.cnblogs.com/tiancai/p/6885293.html
	public static void main(String[] args) {

		int i = 11/10;
		System.out.println(i);

		int productPrice = new Product(){
			public int getPrice(){

				return 100;

			}
		}.getPrice();

		System.out.println(productPrice);


		Function<Pipeline, Response<String>> sss = just(Pipeline::getDel, "sss");
		Pipeline pipeline = new Pipeline();
		System.out.println(sss.apply(pipeline).r);
	}

	public  static  <R, T1> Function<Pipeline, Response<R>> just(PipelineFunction1<T1, R> pipelineFunction, T1 t1) {

		Assert.notNull(pipelineFunction, "PipelineFunction must not be null!");

		 return it -> pipelineFunction.apply(it, t1);
	}


	private static class Pipeline{

		public Pipeline() {
		}

		public  Response<String> getDel(String key) {

			Response<String> response = new Response<>(key);
			return  response;
		}
	}

	private static class Response<R> {

		public Response(R r) {
			this.r = r;
		}

		private R r;

	}

	@FunctionalInterface
	interface PipelineFunction1<T1, R> {

		/**
		 * Apply this function to the arguments and return a {@link String}.
		 *
		 * @param connection the connection in use. Never {@literal null}.
		 * @param t1 first argument.
		 */
		Response<R> apply(Pipeline connection, T1 t1);
	}
}
