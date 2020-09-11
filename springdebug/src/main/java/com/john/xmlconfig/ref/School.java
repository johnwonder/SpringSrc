package com.john.xmlconfig.ref;

/**
 * @Description: SpringSrc
 * @Author: johnwonder
 * @Date: 2020/8/11
 */
public class School {
	private Students students;
	private Teachers teachers;

	public School(Students students,Teachers teachers) {
		this.students = students;
		this.teachers = teachers;
	}
	public Students getStudents() {
		return students;
	}

	public Teachers getTeachers() {
		return teachers;
	}
}
