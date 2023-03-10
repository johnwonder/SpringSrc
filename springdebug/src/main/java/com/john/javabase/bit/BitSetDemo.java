package com.john.javabase.bit;

import java.util.BitSet;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2022/12/2
 */
public class BitSetDemo {

	public static void main(String[] args) {

		BitSet bitSet1 =new BitSet();
		bitSet1.set(2,3);

		int ii = 6 >>> - 2 ;
		System.out.println("ii"+ii);


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

		int[] i = new int[ ] { 1,2 };
		int[][] intervals =  new  int[][]{ new int[]{1,4},new int[] {4,5}};
		int[][] ints = merge2(intervals);

		System.out.println(ints.length);
	}

	public static int[][] merge2(int[][] intervals) {
		BitSet bitSet = new BitSet();
		int max = 0;
		for (int[] interval : intervals) {
			// 比如[1,4]和[5,6]两个区间在数轴上是不连续的，但在BitSet上却是连续的。乘2是为了让它们从BitSet上看也是不连续的
			// bitSet.set() 函数 [x,y)
			int temp = interval[1] * 2 + 1;
			bitSet.set(interval[0] * 2, temp, true);
			max = temp >= max ? temp : max;
		}

		int index = 0, count = 0;
		while (index < max) {
			int start = bitSet.nextSetBit(index);
			int end = bitSet.nextClearBit(start);

			int[] item = {start / 2, (end - 1) / 2};
			intervals[count++] = item;

			index = end;
		}
		int[][] ret = new int[count][2];
		for (int i = 0; i < count; i++) {
			ret[i] = intervals[i];
		}

		return ret;
	}
}
