package com.john.javabase.collection;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2021/4/26
 */
public class Emp implements  Comparable<Emp>{
	private int empno;
	private String ename;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}

	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}

	@Override
	public int compareTo(Emp emp) {
		/*按员工编号正序排序*/
		return this.getEmpno()-emp.getEmpno();
		/*按员工编号逆序排序*/
		//return emp.getEmpno()-this.getEmpno();
		/*按员工姓名正序排序*/
		//return this.getEname().compareTo(emp.getEname());
		/*按员工姓名逆序排序*/
//		return emp.getEname().compareTo(this.getEname());
	}

	@Override
	public String toString()
	{
		return "empno:\t"+empno+"\tename:\t"+ename;
	}
}
