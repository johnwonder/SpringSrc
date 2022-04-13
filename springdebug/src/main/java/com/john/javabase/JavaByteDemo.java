package com.john.javabase;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/1/15
 */
public class JavaByteDemo {

	public static void main(String[] args) {

		//https://segmentfault.com/q/1010000000437587
		//计算机可以通过补码，正确地运算二进制减法。
		//
		//我们再来用 3+(-2) 来验证一下。
		// 正数 3 的补码仍然是 0000…0011，
		// -2 的补码是 1111…1110，两者相加，最后得到了正确的结果 1 的二进制。

		//https://blog.csdn.net/weixin_39669638/article/details/114127119
		//byte，即字节，由8位的二进制组成。
		// 在Java中，byte类型的数据是8位带符号的二进制数。
		//在计算机中，8位带符号二进制数的取值范围是[-128, 127]，所以在Java中，byte类型的取值范围也是[-128, 127]。

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
		// 11111111的原码为00000001 为1
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
		int cc = 230; //1110 0110;
		byte testCC = (byte) cc; // 相当于 1110 0110 以补码形式保存
		System.out.println(testCC); //打印-26

		int dd =241; // 1 111 0001;
		byte testDD = (byte) dd; // 相当于 1110 0110 以补码形式保存
		System.out.println(testDD); //打印-26
	}
}
