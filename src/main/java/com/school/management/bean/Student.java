package com.school.management.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class Student {

	private Integer studentId;
	@Size(min = 2, message = "Name should not be less than 2 characters")
	private String name;
	private String place;
	private String course;
	@Digits(integer = 4,message = "Year should be numeric in form of YYYY", fraction = 0)
	@Size(min = 4, max = 4, message = "Year can only be of 4 digits in the form YYYY")
	private String year;
 
	public Student(Integer studentId, String name, String place, String course, String year) {
		this.studentId = studentId;
		this.name = name;
		this.place = place;
		this.course = course;
		this.year = year;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", place=" + place + ", course=" + course
				+ ", year=" + year + "]";
	}

}
