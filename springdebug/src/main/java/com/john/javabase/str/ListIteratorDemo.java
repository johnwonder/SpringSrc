package com.john.javabase.str;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
public class ListIteratorDemo {

	//https://blog.csdn.net/qq_41623154/article/details/93778064
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		ListIterator<String> listIt = list.listIterator();
		while(listIt.hasNext()){
			String next = listIt.next();
			if(next.equals("b")){

				listIt.set("new");

			}

		}

		System.out.println(list);
		List<String> lista = new ArrayList<>();
		lista.add("a");
		lista.add("b");
		lista.add("c");
		lista.add("d");
		ListIterator<String> listIt1 = lista.listIterator();

		StringBuilder sb = new StringBuilder();
		while(listIt1.hasNext()){
			 sb.append(listIt1.next());
			 if(listIt1.hasNext())
			 sb.append(";");
		}
		System.out.println(sb.toString());

	}
}
