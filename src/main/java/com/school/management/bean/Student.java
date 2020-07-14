package com.school.management.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties( value = {"course","year"} )
@Entity( name = "STUDENTDETAILS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	@Size(min = 2, message = "Name should not be less than 2 characters")
	private String name;

	@JsonIgnore
	private String place;
	private String course;
	@Digits(integer = 4,message = "Year should be numeric in form of YYYY", fraction = 0)
	@Size(min = 4, max = 4, message = "Year can only be of 4 digits in the form YYYY")
	private String year;

	@Temporal(TemporalType.DATE)
	private Date registrationDate;

	@Temporal(TemporalType.TIME)
	private Date registrationTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sessionStartDateTime;

	@OneToMany(mappedBy = "student")
	private List<Subject> subjects;

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


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Student(Integer studentId, @Size(min = 2, message = "Name should not be less than 2 characters") String name,
			String place, String course,
			@Digits(integer = 4, message = "Year should be numeric in form of YYYY", fraction = 0) @Size(min = 4, max = 4, message = "Year can only be of 4 digits in the form YYYY") String year,
			Date registrationDate, Date registrationTime, Date sessionStartDateTime, List<Subject> subjects) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.place = place;
		this.course = course;
		this.year = year;
		this.registrationDate = registrationDate;
		this.registrationTime = registrationTime;
		this.sessionStartDateTime = sessionStartDateTime;
		this.subjects = subjects;
	}

}
