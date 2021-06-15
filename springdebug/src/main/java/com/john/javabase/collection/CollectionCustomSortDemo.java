package com.john.javabase.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
public class CollectionCustomSortDemo {


	static List<Emp> empList;

	static
	{
		Emp emp1 = new Emp(2,"Guan YunChang");
		Emp emp2 = new Emp(3,"Zhang Fei");
		Emp emp3 = new Emp(1,"Liu Bei");
		empList = Arrays.asList(emp1,emp2,emp3);
	}
	public static void main(String[] args) {

		System.out.println("before sort:");
		System.out.println(empList);
		System.out.println("=========================");

		System.out.println("after sort:");
		Collections.sort(empList);

		System.out.println(empList);
//		Collections.sort(empList, (o1, o2) -> {
//			/*按员工编号正序排序*/
//			return o1.getEmpno()-o2.getEmpno();
//			/*按员工编号逆序排序*/
//			//return o2.getEmpno()-o1.getEmpno();
//			/*按员工姓名正序排序*/
//			//return o1.getEname().compareTo(o2.getEname());
//			/*按员工姓名逆序排序*/
//			//return o2.getEname().compareTo(o1.getEname());
//		});
		//System.out.println("after regular sort:");
		//System.out.println(empList);

		Comparator<Emp> comparator = (o1, o2) -> {
			/*按员工编号正序排序*/
			return o1.getEmpno()-o2.getEmpno();
			/*按员工编号逆序排序*/
			//return o2.getEmpno()-o1.getEmpno();
			/*按员工姓名正序排序*/
			//return o1.getEname().compareTo(o2.getEname());
			/*按员工姓名逆序排序*/
			//return o2.getEname().compareTo(o1.getEname());
		};
		System.out.println("=========================");
		/*新的逆序实现方式*/
		//且使用了 接口默认方法。。
		empList.sort(comparator.reversed());


		System.out.println("after reversed sort:");
		System.out.println(empList);

		empList.sort(null);

		System.out.println(empList);

		//https://www.cnblogs.com/yw0219/p/7222108.html
	}
}
