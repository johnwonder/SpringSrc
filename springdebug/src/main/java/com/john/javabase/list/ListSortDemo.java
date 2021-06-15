package com.john.javabase.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/6/1
 */
public class ListSortDemo {

	public static void main(String[] args) {


		List<OptInfo> optInfos =new ArrayList<>();
		optInfos.add(new OptInfo());

		OptInfo optInfo = new OptInfo();
		//optInfo.setOrderInd(1L);
		optInfos.add(optInfo);

		sortList(optInfos);

		Object[] iArr = new Object[]{ 5,4,3,2,1};

		reverseRange(iArr,0,5);

		for (Object o : iArr) {

			System.out.println(o);
		}

		String[] strArr = new String[] { "a","b","c","d"};
		arrayCopy(strArr,3,0);
	}

	/**
	 * https://blog.csdn.net/liuxiao723846/article/details/53760363 图解sort
	 * Comparison method violates its general contract!
	 * https://q.cnblogs.com/q/126253/
	 * https://www.cnblogs.com/firstdream/p/7204067.html
	 * https://blog.csdn.net/samur2/article/details/109231250
	 * //https://stackoverflow.com/questions/6626437/why-does-my-compare-method-throw-exception-comparison-method-violates-its-gen
	 * //https://stackoverflow.com/questions/8327514/comparison-method-violates-its-general-contract
	 * @param optInfos
	 */
	private static void sortList(List<OptInfo> optInfos) {

		optInfos.sort((a, b) -> a.getOrderInd() == null ? 1 : (b.getOrderInd() == null ? -1 : Long.compare(a.getOrderInd(), b.getOrderInd())));
	}

	private static  void arrayCopy(String[] strArr,int left,int n){

		System.arraycopy(strArr, left, strArr, left + 1, n);

		for (String s : strArr) {
			System.out.println(s);
		}
	}

	//降序反转成升序
	/**
	 * Reverse the specified range of the specified array.
	 *
	 * @param a the array in which a range is to be reversed
	 * @param lo the index of the first element in the range to be reversed
	 * @param hi the index after the last element in the range to be reversed
	 */
	private static void reverseRange(Object[] a, int lo, int hi) {
		hi--;
		while (lo < hi) {
			Object t = a[lo];
			a[lo++] = a[hi];
			a[hi--] = t;
		}
	}

	static  class  OptInfo {

		private Long orderInd;

		public Long getOrderInd() {
			return orderInd;
		}

		public void setOrderInd(Long orderInd) {
			this.orderInd = orderInd;
		}
	}
}
