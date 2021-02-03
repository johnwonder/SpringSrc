package com.john.javabase;

import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Description: spring
 * @Author: johnwonder
 * @Date: 2021/1/6
 */
public class TestStringTokens {

	public static void main(String[] args) throws Exception {


		//0x010000
		int cp = 0x20BB7;//0x20b9f; // CJK Ideograph Extension B
		//一个codePoint
		String str1 = new String(new int[]{cp}, 0, 1);// processing time: 206ms

		//长度为2
		System.out.println("0x20BB7的字符串长度为："+str1.length());
		//134071
		System.out.println(str1.codePointAt(0));

//		String str2 = new String(Character.toChars(cp));                  //  187ms
//		String str3 = String.valueOf(Character.toChars(cp));              //  195ms
//		String str4 = new StringBuilder().appendCodePoint(cp).toString(); //  269ms
//		String str5 = String.format("%c", cp);                            // 3781ms

//		System.out.println(str1);
//		System.out.println(str1.length());
//		byteTest(str1, charset);
//		System.out.println("============================");

		//1. charset为"UTF-16"时, java会默认添加BOM [0xFE, 0xFF], 并以BE的格式编写byte
		//2. charset为"UTF-16BE"时, java不会添加BOM, 但编码方式为 BE
		//3. charset为"UTF-16LE"时, java不会添加BOM, 但编码方式为 LE
		//https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51150247
		String[] strArr = {str1,"儱","中", "��", "a", "aa"};
		//String[] charsetArr = {"gbk", "utf-8", "utf-16", "gb2312"};
		String[] charsetArr = {"unicode", "utf-8", "utf-16", "utf-16BE", "utf-16LE"};
		for(String str : strArr) {
			System.out.println(str);

			System.out.println("字符串长度为："+str.length());

			for(String charset : charsetArr) {
				byteTest(str, charset);
			}
			System.out.println("============================");
		}

		//Collections

		//Java中的UTF-8、UTF-16编码字符所占字节数
		//https://blog.csdn.net/worm0527/article/details/70833531
		//https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51150247


		//javascript中的codePoint
		//https://blog.csdn.net/ixygj197875/article/details/79090503

		//ibm
		//https://www.ibm.com/developerworks/cn/java/j-unicode/

		//java的中文到底占几个字节？
		//https://segmentfault.com/q/1010000003757947
		//https://www.cnblogs.com/lslk89/p/6898526.html

		//String delimiters = "中";//new String("?".getBytes("UTF-16"));

		//字节长度为3
//		System.out.println(delimiters.getBytes().length);
//
//		System.out.println(delimiters.charAt(0));
//		int c = delimiters.charAt(0);
//		System.out.println(c);
//
//		System.out.println(delimiters.codePointAt(0));
//
//		System.out.println(delimiters.length());;
//
//		System.out.println(Character.charCount(c));
//
//		StringTokenizer st = new StringTokenizer("this is a test");
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

		//setMaxDelimCodePoint(delimiters);
	}

	public static void byteTest(String str, String charset) throws Exception {

		byte[] strByte = str.getBytes(charset);
		System.out.println("编码：" + charset
				+ "\t所占字节数：" + strByte.length
				+ "\t16进制：" + bytesToHexStr(strByte));
	}

	private static char[] HEX_CHAR = {'0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	// 将byte[]用十六进制字符串
	public static String bytesToHexStr(byte[] bytes) {
		int index = 0;
		char[] hexChar = new char[bytes.length * 2];
		for(int i = 0; i < bytes.length; i++) {
			hexChar[index++] = HEX_CHAR[bytes[i] >> 4 & 0xF];
			hexChar[index++] = HEX_CHAR[bytes[i] & 0xF];
		}
		return new String(hexChar);
	}



	private static int[] delimiterCodePoints;
	private static  Boolean hasSurrogates;
	private static void setMaxDelimCodePoint(String delimiters) {

		//https://www.cnblogs.com/duguxiaobiao/p/9128817.html

		//https://www.zhihu.com/question/294660079

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
