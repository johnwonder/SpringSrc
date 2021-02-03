package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/15
 */
public class JavaByteDemo {

	public static void main(String[] args) {

		//https://www.cnblogs.com/zhang188660586/p/9752394.html
		//https://www.cnblogs.com/545018520xq/articles/6744933.html
		//https://www.cnblogs.com/zl181015/archive/2004/01/13/9435035.html
		//负数在计算机中都是以补码的形式保存的，
		int b = 456; //11001000
		byte test = (byte) b; //
		System.out.println(test);

		int d = 2571; //00001011
		byte testD = (byte)d; //
		System.out.println(testD);

		//-1的原码是 1,0000001
		//反码是1,1111110
		//补码是1,1111111
		int a = -1;
		byte testA = (byte) a;
		System.out.println(testA);

		//257的原码是100000001
		int f = 257;
		byte testF = (byte) f;
		System.out.println(testF);

		//385的原码是110000001
		// 10000001 表示补码
		// 10000001的原码为11111111 为-127
		int g = 385;
		byte testG = (byte) g;
		System.out.println(testG);

		//385的原码是111111111
		// 11111111 表示补码 以补码保存
		// 11111111的原码为10000001 为-1
		int h = 511;
		byte testH = (byte) h;
		System.out.println(testH);

		int c = -128; //10000000

		byte testC = (byte) c;
		System.out.println(testC);

		int e = -129; //110000001
		byte testE = (byte) e;
		System.out.println(testE);

		//https://www.cnblogs.com/zl181015/archive/2004/01/13/9435035.html
		//补码
		//补码 到原码
		//取反 + 1
	}
}
