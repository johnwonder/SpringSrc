package com.john.javabase;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/12/29
 */
public class UTF_8_TEST {

	//https://blog.csdn.net/qq_22771739/article/details/84261165
	//https://zhuanlan.zhihu.com/p/24313237
	//https://blog.csdn.net/waitingbb123/article/details/80504093 大端和小端
	public static void main(String[] args) {

		//https://zhuanlan.zhihu.com/p/25442427
		//直接使用字节流从控制台读入UTF-8编码的汉字时，读入的就是上面的三个字节，也就是原始的UTF-8编码
		//https://blog.csdn.net/weixin_43266529/article/details/107876407

		//但如果使用字符流去读的话，得到的就是unicode码
		byte[] b = {-26, -75, -73};
//		ByteBuffer bb = ByteBuffer.allocate(3);
//		bb.put(b, 0, 3);
//		bb.flip();

		//字符流读取
		//CharBuffer cb = UTF_8.decode(bb);
		//char c = cb.charAt(0);

		//utf-8解码
		char[] c = new char[3];
		decode(b,0,3,c);
		System.out.println(new String(c));

		//读取字节流
		System.out.println(new String(b));


		//使用字符流去读入UTF-8编码的汉字的话，得到的就是unicode码
		char e = '海'; //0110 1101 0111 0111
		//6D77
		System.out.println(e);

		//cpu LITTLE_ENDIAN
		System.out.println(ByteOrder.nativeOrder());

		//https://blog.csdn.net/weixin_39670441/article/details/114050004
		//默认字节序  BIG_ENDIAN
		ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[4]);
		System.out.println(byteBuffer.order().toString());

		String ee = "海";
		System.out.println(ee.getBytes(StandardCharsets.UTF_16LE));
		//109 0110 1101 = 6D
		//119 0111 0111 = 77

		byte[] bee = ee.getBytes(StandardCharsets.UTF_16LE);


		//utf-8编码
		String d = "\u6d77";

		//System.out.println(d.getBytes());
		System.out.println(d.getBytes(UTF_8));

		byte[] da = new byte[3];
		int dp = 0;

		da[dp++] = (byte)(0xe0 | ((d.charAt(0) >> 12))); //-26 // 11100000 |  （ 0110 1101 0111 0111 >>12)
		da[dp++] = (byte)(0x80 | ((d.charAt(0)  >>  6) & 0x3f));
		da[dp++] = (byte)(0x80 | (d.charAt(0)  & 0x3f));


	    ee = "你";
		System.out.println(ee.getBytes(StandardCharsets.UTF_16BE));
		//先读到的是高位字节
		//第一个字节79 4F 01001111 64+8+4+2+1
		//第二个字节96 60

		String d1 = "\u4f60";
		System.out.println(d1);
		//参考资料：
		//https://www.cnblogs.com/skywang12345/p/3360348.html
		//https://blog.csdn.net/weixin_34168167/article/details/114065242
		//https://blog.csdn.net/anlian523/article/details/120774417 大端小端
	}

	private static String replacement(){
		return "\uFFFD";
	}

	// returns -1 if there is/are malformed byte(s) and the
	// "action" for malformed input is not REPLACE.
	public static int decode(byte[] sa, int sp, int len, char[] da) {
		final int sl = sp + len;
		int dp = 0;
		int dlASCII = Math.min(len, da.length);
		ByteBuffer bb = null;  // only necessary if malformed

		// ASCII only optimized loop
		//sp为原来的位置
		while (dp < dlASCII && sa[sp] >= 0)
			da[dp++] = (char) sa[sp++];

		while (sp < sl) {
			int b1 = sa[sp++];
			if (b1 >= 0) {
				//dp
				// 1 byte, 7 bits: 0xxxxxxx
				da[dp++] = (char) b1;
			} else if ((b1 >> 5) == -2 && (b1 & 0x1e) != 0) {
				//(b1 >> 5) == -2 =  11000000
				//0x1e = 00010111
				// 2 bytes, 11 bits: 110xxxxx 10xxxxxx
				if (sp < sl) {
					int b2 = sa[sp++];
//					if (isNotContinuation(b2)) {
//						if (malformedInputAction() != CodingErrorAction.REPLACE)
//							return -1;
//						da[dp++] = replacement().charAt(0);
//						sp--;            // malformedN(bb, 2) always returns 1
//					} else
 					{
						//0xC0= 11000000
						da[dp++] = (char) (((b1 << 6) ^ b2)^
								(((byte) 0xC0 << 6) ^
										((byte) 0x80 << 0)));
					}
					continue;
				}
//				if (malformedInputAction() != CodingErrorAction.REPLACE)
//					return -1;
				da[dp++] = replacement().charAt(0);
				return dp;
			} else if ((b1 >> 4) == -2) {
				// 3 bytes, 16 bits: 1110xxxx 10xxxxxx 10xxxxxx
				if (sp + 1 < sl) {
					int b2 = sa[sp++];
					int b3 = sa[sp++];
//					if (isMalformed3(b1, b2, b3)) {
//////						if (malformedInputAction() != CodingErrorAction.REPLACE)
//////							return -1;
////						da[dp++] = replacement().charAt(0);
////						sp -= 3;
////						bb = getByteBuffer(bb, sa, sp);
////						sp += malformedN(bb, 3).length();
////					}
						// else
				      {
						char c = (char)((b1 << 12) ^
								(b2 <<  6) ^
								(b3 ^
										(((byte) 0xE0 << 12) ^
												((byte) 0x80 <<  6) ^
												((byte) 0x80 <<  0))));
						if (Character.isSurrogate(c)) {
//							if (malformedInputAction() != CodingErrorAction.REPLACE)
//								return -1;
							da[dp++] = replacement().charAt(0);
						} else {
							da[dp++] = c;
						}
					}
					continue;
				}
//				if (malformedInputAction() != CodingErrorAction.REPLACE)
//					return -1;
//				if (sp  < sl && isMalformed3_2(b1, sa[sp])) {
//					da[dp++] = replacement().charAt(0);
//					continue;
//
//				}
				da[dp++] = replacement().charAt(0);
				return dp;
			} else if ((b1 >> 3) == -2) {
				// 4 bytes, 21 bits: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
				if (sp + 2 < sl) {
					int b2 = sa[sp++];
					int b3 = sa[sp++];
					int b4 = sa[sp++];
					int uc = ((b1 << 18) ^
							(b2 << 12) ^
							(b3 <<  6) ^
							(b4 ^
									(((byte) 0xF0 << 18) ^
											((byte) 0x80 << 12) ^
											((byte) 0x80 <<  6) ^
											((byte) 0x80 <<  0))));
//					if (isMalformed4(b2, b3, b4) ||
//							// shortest form check
//							!Character.isSupplementaryCodePoint(uc)) {
//						if (malformedInputAction() != CodingErrorAction.REPLACE)
//							return -1;
//						da[dp++] = replacement().charAt(0);
//						sp -= 4;
//						bb = getByteBuffer(bb, sa, sp);
//						sp += malformedN(bb, 4).length();
//					} else
						{
						da[dp++] = Character.highSurrogate(uc);
						da[dp++] = Character.lowSurrogate(uc);
					}
					continue;
				}
//				if (malformedInputAction() != CodingErrorAction.REPLACE)
//					return -1;

//				if (sp  < sl && isMalformed4_2(b1, sa[sp])) {
//					da[dp++] = replacement().charAt(0);
//					continue;
//				}
				sp++;
//				if (sp  < sl && isMalformed4_3(sa[sp])) {
//					da[dp++] = replacement().charAt(0);
//					continue;
//				}
				da[dp++] = replacement().charAt(0);
				return dp;
			} else {
//				if (malformedInputAction() != CodingErrorAction.REPLACE)
//					return -1;
				da[dp++] = replacement().charAt(0);
			}
		}
		return dp;
	}

}
