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

		System.out.println(Byte.parseByte("01111111",2));

		System.out.println(((byte) 100000000));

		//73的二进制1001001
		System.out.println(((byte) 01111111));

		int jjj = 01111111; //因为代表了8进制 8进制转换为10进制等于299593
		System.out.println(jjj);
		//299593的二进制为1001001001001001001

		try {
			System.out.println(tryParseByte());

		}catch (NumberFormatException e){
			System.out.println(e);
		}

		System.out.println(Byte.decode("-100"));

		System.out.println(Byte.compare((byte) 0x10, (byte) 0x20));
	}

	public static byte tryParseByte(){
		return Byte.parseByte("200",2);
	}
}
