package com.john.jfinal;

import java.util.Random;

/**
 * @Description: SpringSrc
 * @Author: zhangjiong
 * @Date: 2020/4/5
 */
public class FinalData {

	private  static Random rand = new Random(47);

	private  String id;

	public  FinalData(String id) {
		this.id = id;
	}

	private final int valueOne = 9;

	private static  final  int VALUE_TWO = 99;

	public  static final  int VALUE_THREE = 39;

	private  final  int i4 = rand.nextInt(20);

	static  final int INT_5 = rand.nextInt(20);

	private  Value v1 = new Value(11);

	private  final  Value v2 = new Value(22);

	private  static  final  Value VAL_3 = new Value(33);

	private  final  int[] a = {1,2,3};

	public String toString(){
		return  id + ": " + "i4= " + i4+", INT_5=" + INT_5;
	}

	public  static  void main(String[] args){

		 FinalData fd1 = new FinalData("fd1");

		 //fd1.a = new int[3];


	}
}
