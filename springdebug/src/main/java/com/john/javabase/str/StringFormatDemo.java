package com.john.javabase.str;

import java.util.*;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/9/27
 */
public class StringFormatDemo {

	public static void main(String[] args) {

		System.out.printf("%S%n", "gpk");
		//https://mp.weixin.qq.com/s?__biz=MzU3MTAzNTMzMQ==&mid=2247486701&idx=1&sn=26268a35c3849406c97847a485baff07&chksm=fce71741cb909e572fb112f7ba643a797bb89823cd46452fe383c000bd7a571e5c29aac1825c&token=746106928&lang=zh_CN&scene=21#wechat_redirect
		String s =String.format("我是 %s","john");
		System.out.println(s);

		StringBuilder sb = new StringBuilder();
		// Send all output to the Appendable object sb
		Formatter formatter = new Formatter(sb, Locale.US);

		//https://www.cnblogs.com/gxhunter/p/11296742.html
		//https://segmentfault.com/a/1190000019350486
		// Explicit argument indices may be used to re-order output.
		System.out.println(formatter.format("%4$2s %3$2s %2$2s %1$2s \n", "a", "b", "c", "d"));

		//用括号包含负数 $ (12,345.57)
		System.out.println(formatter.format("Amount gained or lost since last statement: $ %(,.2f",
				-12345.567));

		//float[] f = new float[] { 1.25f,2.52f};
		//System.out.println(formatter.format("%5.2f", f));


		float df = 1.25f;
		System.out.println(formatter.format("%8.2f", df));

		StringBuilder array = new StringBuilder();
		// Send all output to the Appendable object sb
		Formatter arrayFormatter = new Formatter(array, Locale.US);
		//实现Formattable 接口
		//go语言中直接可以格式化slice
		System.out.println(arrayFormatter.format("[%s]", new FloatFormatter(1.25f,2.52f)));

	}

	private static class  FloatFormatter implements Formattable{

		private final Float[] fs ;
		public FloatFormatter(Float... f) {
			fs = f;
		}

		@Override
		public void formatTo(Formatter formatter, int flags, int width, int precision) {

			Iterator<Float> floatIterator = Arrays.asList(fs).iterator();

			while (floatIterator.hasNext()){

				Float current = floatIterator.next();
				formatter.format("%1.2f"+ (floatIterator.hasNext() ? " ":""),current );
			}

		}
	}
}
