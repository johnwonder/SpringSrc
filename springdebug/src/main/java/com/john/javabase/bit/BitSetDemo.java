package com.john.javabase.bit;

import java.util.BitSet;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/12/2
 */
public class BitSetDemo {

	public static void main(String[] args) {


		BitSet bitSet =new BitSet();
		bitSet.set(128);

	    long l =	1L << 128;
		System.out.println(l);

		long l1 = 1L << 129;
		System.out.println(l1);

		long l2 = (1L << 63)  -1L;
		System.out.println(l2);

		long l3 = 1L << 62;
		System.out.println(l3);

		System.out.println(Long.MAX_VALUE );


		boolean b = bitSet.get(128);
		System.out.println(b);
	}
}
