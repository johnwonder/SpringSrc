package com.john.javabase;

import java.util.HashMap;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/9/11
 */
public class TestHashMap {

	//https://blog.csdn.net/Fighting_mjtao/article/details/81415357
	//https://blog.csdn.net/f641385712/article/details/81880711

	//https://blog.csdn.net/weixin_43689776/article/details/99999126
	public static void main(String[] args) {

		int h =1290846991;
		int hash = h ^ (h >>> 16);

		System.out.println(hash);

		HashMap arr=new HashMap();
		String a="111";
		String b=new String("111");

		System.out.println(a);//111
		System.out.println(b);//111
		System.out.println(a == b);///false
		System.out.println(a.equals(b));//true

		//https://m.imooc.com/wenda/detail/545901
		System.out.println("a的hashcode:" + a.hashCode()); //48657
		System.out.println("b的hashcode:" + b.hashCode()); //48657
		arr.put(a,"aaaaa");
		arr.put(b,"bbbbb");
		System.out.println(arr); //{111=bbbbb}
		System.out.println(arr.get(a)); //bbbbb
	}
}
