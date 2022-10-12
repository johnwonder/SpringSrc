package com.john.javabase.bit;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/7/21
 */
public class BitCompareDemo {

	public static void main(String[] args) {

		int i = 4;
		int j =2;

		//-10

		//0000 1010
		//1111 0110


		int ii = 0xC0000000 >> 30;
		int jj = 0xC0000000;

		int vv = 0xC0000000 >> 1;

		int yy = 0x80000000;
		int yyy = 0x80000000 >> 30;

		System.out.println(yy);
		System.out.println(yyy);
		//1000 0000 0000 0000 0000 0000 0000 0000
		//直接移动30位 1111 1111 1111 1111 1111 1111 1111 1110
		//高位补1


		System.out.println(vv);
		//1100 0000 0000 0000 0000 0000 0000 0000

		//移动30位 1111 1111 1111 1111 1111 1111 1111 1111
		//高位补1
		System.out.println(jj);

		System.out.println(ii);
	}
}
