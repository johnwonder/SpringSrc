package com.john.javabase;

import java.util.StringTokenizer;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/6
 */
public class TestStringTokens {

	public static void main(String[] args) {
		String delimiters = "?";//new String("?".getBytes("UTF-16"));

		System.out.println(delimiters.charAt(0));
		int c = delimiters.charAt(0);
		System.out.println(c);

		System.out.println(delimiters.codePointAt(0));

		System.out.println(delimiters.length());;

		System.out.println(Character.charCount(c));

		StringTokenizer st = new StringTokenizer("this is a test");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		//setMaxDelimCodePoint(delimiters);
	}


	private static int[] delimiterCodePoints;
	private static  Boolean hasSurrogates;
	private static void setMaxDelimCodePoint(String delimiters) {


		//Surrogate 這個概念，不是來自 Java 語言，而是來自 Unicode 編碼方式之一 UTF-16 。具體請見： UTF-16
		// 簡而言之，Java 語言內部的字符信息是使用 UTF-16 編碼。
		// 因為，char 這個類型是 16-bit 的。它可以有65536種取值，即65536個編號，每個編號可以代表1種字符。
		// 但是，Unicode 包含的字符已經遠遠超過65536個。那，編號大於65536的，還要用 16-bit 編碼，該怎麼辦？
		// 於是，Unicode 標準制定組想出的辦法就是，從這65536個編號裏，拿出2048個，規定它們是「Surrogates」，
		// 讓它們兩個為一組，來代表編號大於65536的那些字符。
		// 更具體地，編號為 U+D800 至 U+DBFF 的規定為「High Surrogates」，共1024個。
		// 編號為 U+DC00 至 U+DFFF 的規定為「Low Surrogates」，也是1024個。
		// 它們兩兩組合出現，就又可以多表示1048576種字符。
		//
		//作者：圓月亮
		//链接：https://www.zhihu.com/question/42176549/answer/93852738
		//来源：知乎
		//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		int m = 0;
		int c;
		int count = 0;
		for (int i = 0; i < delimiters.length(); i += Character.charCount(c)) {
			c = delimiters.charAt(i);
			if (c >= Character.MIN_HIGH_SURROGATE && c <= Character.MAX_LOW_SURROGATE) {
				c = delimiters.codePointAt(i);
				hasSurrogates = true;
			}
			if (m < c)
				m = c;
			count++;
		}

		if (hasSurrogates) {
			delimiterCodePoints = new int[count];
			for (int i = 0, j = 0; i < count; i++, j += Character.charCount(c)) {
				c = delimiters.codePointAt(j);
				delimiterCodePoints[i] = c;
			}
		}
	}
}
