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
		System.out.println(test); //打印-56

		int d = 2571; //00001011
		byte testD = (byte)d; //
		System.out.println(testD); //打印11，因为byte占一个字节

		//1的原码是 0000 .... 0000001
		//反码是11111 .... 11111110
		//补码是1111  .... 11111111 代表-1
		//截取8位 为 11111111 -1的二进制
		int a = -1;
		byte testA = (byte) a;
		System.out.println(testA); //打印-1

		//257的原码是100000001 舍去高位1  就变为1了。
		int f = 257;
		byte testF = (byte) f; //
		System.out.println(testF); //打印1

		//385的原码是110000001 舍去高位1
		// 10000001 表示补码 -127
		int g = 385;
		byte testG = (byte) g;
		System.out.println(testG); //打印-127

		//511的原码是111111111
		// 11111111 表示补码 以补码保存
		// 11111111的原码为10000001 为-1
		int h = 511;
		byte testH = (byte) h;
		System.out.println(testH); //打印-1

		int c = -128; //10000000
		//以补码 1000 0000 保存 最高位为1要取反 + 1 所以打印-128
		byte testC = (byte) c;
		System.out.println(testC);//打印-128

		int e = -129;
		//129 原码 0000 .... 1000 0001  ////
		//以129的补码 1111 .... 0111 1111 保存
		// 截取8位 0111 1111  所以打印127
		byte testE = (byte) e;
		System.out.println(testE); //打印127

		//https://www.cnblogs.com/zl181015/archive/2004/01/13/9435035.html
		//补码
		//补码 到原码
		//取反 + 1
	}
}
